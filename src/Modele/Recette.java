package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileReader;
import java.io.IOException;

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


}