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
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;



public class Livre {
	public HashMap<String,Recette> dico_recettes;
	public int nb_recettes;
	
	public Livre() {
		this.dico_recettes= new HashMap();
		this.nb_recettes=0;
		String rep = "Recettes";
		File file = new File(rep);
		String chemin = file.getAbsolutePath();
		File repertoire = new File(chemin);
		File[] recettes = repertoire.listFiles();
		for(int i=0; i< recettes.length; i++) {
			Recette r=fileToRecette(recettes[i]);
			this.dico_recettes.put(r.nom,r );
			this.nb_recettes+=1;	
		}
		
	}
	
	public void ajoutRecette(Recette r) {
		this.nb_recettes+=1;
		this.dico_recettes.put(r.nom, r);
		r.id=this.nb_recettes;
		
	}
	

	
	public Recette fileToRecette(File fichier){
		Recette r = new Recette();
		try
		{
  
		// CrÃ©er l'objet File Reader
		FileReader fr = new FileReader(fichier);  
		// CrÃ©er l'objet BufferedReader        
		BufferedReader br = new BufferedReader(fr);   
		String line;

	    r.nom=line = br.readLine().toString();

	    r.saveur = br.readLine().toString();
	    
	    
	    String[] parts = br.readLine().toString().split("/");
	    for(int j=0; j<parts.length; j++) {
	        Ingredient ing = new Ingredient();
	        String[] part = parts[j].split(",");
	        ing.nom=part[0];
	        ing.quantite=Integer.parseInt(part[1]);
	        ing.mesure=part[2];
	        r.list_ingredients.put(ing.nom, ing);
	        	}

	    String[] partsEtap = br.readLine().toString().split("/");
	    for(int j=0; j<partsEtap.length; j++) {
	        r.list_etapes.add(partsEtap[j]);;
		    }
	     
	    r.photo = br.readLine().toString();
		//this.ajoutRecette(r); 
		fr.close();
		
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		return r;
		  }
	public Livre charger() {
		Livre l = new Livre();
		String rep = "Recettes";
		File file = new File(rep);
		String chemin = file.getAbsolutePath();
		File repertoire = new File(chemin);
		File[] recettes = repertoire.listFiles();
		for(int i=0; i< recettes.length; i++) {
			fileToRecette(recettes[i]);	//l.ajoutRecette(
		}
		return l;
				
	}
	public ArrayList<Recette> liste(){
		ArrayList<Recette> l = new ArrayList<Recette>();
		//boucle for sur le repertoire "Recettes", on applique la fonction fileToRecette à chaque élément pour pouvoir récup le nom des recettes qu'on affichera dans la fenetre 
		String rep = "Recettes";
		File file = new File(rep);
		String chemin = file.getAbsolutePath();
		File repertoire = new File(chemin);
		File[] recettes = repertoire.listFiles();
		for(int i=0; i< recettes.length; i++) {
			l.add(fileToRecette(recettes[i]));
		}
		return l;
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
