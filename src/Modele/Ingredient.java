package Modele;

import java.util.ArrayList;

public class Ingredient {
	
	public String nom;
	public String mesure;
	public int quantite;
	
	public Ingredient(String n, int q, String m ) {
		this.nom = n;
		this.quantite = q;
		this.mesure = m;

	}
	public Ingredient() {
		this.nom =null;
		this.quantite=0;
		this.mesure=null;
	}
	@Override
	public String toString() {
		return this.nom;
	}

}
