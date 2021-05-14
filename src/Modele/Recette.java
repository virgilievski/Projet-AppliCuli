package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class Recette {
	public Set<Ingredient> list_ingredients; 
	public ArrayList<Etape> list_etapes;
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
		this.list_ingredients = new HashSet();
		this.list_etapes=new ArrayList();
		
	}
	
	public void Ajout_ingredient(Ingredient ing) {
		this.list_ingredients.add(ing);
		
	}
	public void Ajout_etapes( Etape e) {
		this.list_etapes.add(e);
			
	}
	public void recetteToFile() throws IOException {
		String nom = this.nom;
		String chemin = "AppliCuli/Recettes/"+nom+".txt";
		File f = new File("/home/virgilo/eclipse-workspace/AppliCuli/Recettes/test.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
				
				PrintWriter writer = new PrintWriter("/home/virgilo/eclipse-workspace/AppliCuli/Recettes/test.txt");
				writer.println(this.nom);
				writer.println(this.saveur);
			    Iterator<Ingredient> it0 = this.list_ingredients.iterator();
			    while(it0.hasNext()) {
			       writer.print(it0.next().toString()+"/");
				}
			    writer.println();
			    Iterator<Etape> it1 = this.list_etapes.iterator();
			    while(it1.hasNext()) {
			    	writer.print(it1.next().toString()+"/");
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