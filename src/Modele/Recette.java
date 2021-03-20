package Modele;

import java.util.ArrayList;

public class Recette {
	public ArrayList<Ingredient> list_ingredients;
	public int nb_etapes;
	public ArrayList<Etape> list_etapes;
	public String nom;
	public String saveur;
	public String photo; 
	public int id;
	

	
	public Recette(String nom, String s) {
		this.nom=nom;
		this.saveur = s;
		this.list_ingredients = new ArrayList();
		this.list_etapes=new ArrayList();
		this.nb_etapes=0;
		this.list_ingredients=new ArrayList();
		
		
				
	}
	
	public void Ajout_ingredient(Ingredient ing) {
		this.list_ingredients.add(ing);
		
	}
	public void Ajout_etapes( Etape e) {
		this.list_etapes.add(e);
		this.nb_etapes+=1;
		
	}
	
}
