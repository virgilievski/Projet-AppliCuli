package Modele;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Recette {
	public Set<Ingredient> list_ingredients; 
	
	public ArrayList<Etape> list_etapes;
	public String nom;
	public String saveur;
	public String photo; 
	public int id;
	

	
	public Recette(String nom, String s) {
		this.nom=nom;
		this.saveur = s;
		this.list_ingredients = new TreeSet();
		this.list_etapes=new ArrayList();			
	}
	
	public void Ajout_ingredient(Ingredient ing) {
		this.list_ingredients.add(ing);
		
	}
	public void Ajout_etapes( Etape e) {
		this.list_etapes.add(e);
		
		
	}
	
}
