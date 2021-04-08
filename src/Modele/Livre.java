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
	public void recetteToFile(Recette r) throws FileNotFoundException {
		String nom = r.nom;
		String chemin = "Recettes/"+nom+".txt";
		File f = new File(chemin);
		PrintWriter writer = new PrintWriter(chemin);
		writer.println(r.nom);
		writer.println(r.saveur);
	    Iterator it0 = r.list_ingredients.iterator();
	    while(it0.hasNext()) {
	       writer.print(it0.next()+"/");
		}
	    writer.println();
	    Iterator it1 = r.list_etapes.iterator();
	    while(it1.hasNext()) {
	    	writer.print(it1.next()+"/");
	    }
	    writer.println();
	    writer.print(r.photo);
		writer.close();
	}
	
	public ArrayList<Recette>  alaUne() {
		ArrayList tab = new ArrayList<Recette>();
		
		if (this.nb_recettes>3) {
			for (int i=0;i<3;i+=1) {
				tab.add(this.dico_recettes.get(this.nb_recettes-i));
				
			}
				
		}
		return tab;
	}
}
