package Modele;

import java.util.ArrayList;

public class Ingredient {
	
	public String nom;
	public String mesure;
	public float quantite;
	
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
		int a=Math.round(this.quantite);
		String b=""+this.quantite;
		String c=this.mesure;
		
		if (this.mesure.equals("null")) {
			c="";
		}
		if (this.quantite - a==0) {
			b=""+a;
			
		}
		
		return this.nom+" "+b+" "+c;
	}

}
