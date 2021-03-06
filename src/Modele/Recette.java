package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Recette {
	public HashMap<String,Ingredient> list_ingredients; 
	public ArrayList<String> list_etapes;
	public String nom;
	public String saveur;
	public String photo; 
	public int id;

	
	public Recette(String nom, String s) {
		this();
		this.nom=nom;
		this.saveur = s;
		
				
	}
	public Recette() {
		this.list_ingredients = new HashMap();
		this.list_etapes=new ArrayList();
		
	}
	public String getNom() {
		return this.nom;
	
		
	}

		
	
		
	
	public String getSaveur() {
		return this.saveur;
		
	}
	
	public void Ajout_ingredient(Ingredient ing) {
		this.list_ingredients.put(ing.nom,ing);
		
	}
	public void Ajout_etapes( String e) {
		this.list_etapes.add(e);
			
	}
	public void recetteToFile() throws IOException {
		String nom = this.nom;
		String rep = "Recettes";
		File file = new File(rep);
		String chemin = file.getAbsolutePath()+"/"+nom+".txt";
		File f = new File(chemin);
		if (!f.exists()) {
			try {
				f.createNewFile();
				
				PrintWriter writer = new PrintWriter(chemin);
				writer.println(this.nom);
				writer.println(this.saveur);
				for (String i : this.list_ingredients.keySet()) {
					Ingredient h =this.list_ingredients.get(i);
					writer.print(h.nom+","+h.quantite+","+h.mesure+"/");
				}
			    writer.println();
			    Iterator<String> it1 = this.list_etapes.iterator();
			    while(it1.hasNext()) {
			    	writer.print(it1.next()+"/");
			    }
			    writer.println();
			    writer.print(this.photo);
				writer.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}


}