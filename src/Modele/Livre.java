package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Livre {
	public HashMap<Integer,Recette> dico_recettes;
	public int nb_recettes;
	
	
	public Livre() {
		this.dico_recettes= new HashMap();
		this.nb_recettes=0;
	}
	
	public void ajoutRecette(Recette r) {
		this.nb_recettes+=1;
		this.dico_recettes.put(this.nb_recettes, r);
		r.id=this.nb_recettes;
	}
	public void fileToRecette(File fichier){
		try
		{
  
		// Créer l'objet File Reader
		FileReader fr = new FileReader(fichier);  
		// Créer l'objet BufferedReader        
		BufferedReader br = new BufferedReader(fr);   
		String line;
		Recette r = new Recette();

	    r.nom=line = br.readLine().toString();

	    r.saveur = br.readLine().toString();
	    
	    
	    String[] parts = br.readLine().toString().split("/");
	    for(int j=0; j<parts.length; j++) {
	        Ingredient ing = new Ingredient();
	        String[] part = parts[j].split(",");
	        ing.nom=part[0];
	        ing.quantite=Integer.parseInt(part[1]);
	        ing.mesure=part[2];
	        r.list_ingredients.add(ing);
	        	}

	    String[] partsEtap = br.readLine().toString().split("/");
	    for(int j=0; j<partsEtap.length; j++) {
	        Etape eta = new Etape();
	        eta.num�ro=j+1;		
	        eta.instructions=partsEtap[j];
	        r.list_etapes.add(j, eta);;
		    }
	     
	    r.photo = br.readLine().toString();
		        
		      fr.close();    
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		  }
	
	public ArrayList<Recette>  alaUne() {
		ArrayList<Recette> tab = new ArrayList<Recette>();
		
		if (this.nb_recettes>5) {
			for (int i=0;i<5;i+=1) {
				tab.add(this.dico_recettes.get(this.nb_recettes-1-i));
				
			}
				
		}
		return tab;
	}
}
