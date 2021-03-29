package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	public void parsingmaison(File fichier){
		try
		{
  
		// CrÃ©er l'objet File Reader
		FileReader fr = new FileReader(fichier);  
		// CrÃ©er l'objet BufferedReader        
		BufferedReader br = new BufferedReader(fr);  
		StringBuffer sb = new StringBuffer();    
		String line;
		Recette r = new Recette();
		int i=0;
		while((line = br.readLine()) != null) {
	        // ajoute la ligne au buffer
			System.out.println(line.toString() + "  line");
	        sb.append(line);      
	        sb.append("\n");  
	        //premiere ligne : on récupère le nom de la recette
	        if (i==0) {
	        	r.nom=line.toString();
	      }
	        //deuxieme ligne : on récupère la saveur de la recette
	        else if(i==1) {
	        	r.saveur=line.toString();
	        }
	        //troisieme ligne : on récupère le set d'ingrédient de la recette
	        else if(i==2) {
	        	//découpage de notre ligne avec les "/" qui délimite chaque ingrédient du fichier
	        	String[] parts = line.toString().split("/");
	        	//découpage des attributs de chaque ingrédients délimités par ","
	        	for(int j=0; j<parts.length; j++) {
	        		Ingredient ing = new Ingredient();
	        		String[] part = parts[j].split(",");
	        	//On définit ing puis on l'ajoute au set d'ingrédients de la recette
	        		ing.nom=part[0];
	        		ing.quantite=Integer.parseInt(part[1]);
	        		ing.mesure=part[2];
	        		r.list_ingredients.add(ing);
	        	}
	        }
	        //quatrieme ligne : on récupère la liste d'étapes de la recette
	        else if(i==3) {
	        	//On recupere chaque étape du fichier délimitée par "/"
	        	String[] parts = line.toString().split("/");
	        	//On définit eta en lui donnant ses attributs (numéro de l'etape, libellé de l'etape) 
	        	//pour chaque étape du tableau parts[]
	        	for(int j=0; j<parts.length; j++) {
	        		Etape eta = new Etape();
	        		eta.numéro=j+1;
	        		eta.instructions=parts[j];
	        		//on ajoute l'étape eta à la liste d'étapes de la recette
	        		r.list_etapes.add(j, eta);;
	        	}	
		        }
	        //cinquième ligne : on récupère le chemin de la photo
	        else if(i==4) {
		        r.photo=line.toString();
		        }
	        // i s'incrémente à chaque nouvelle ligne lut
		    i=i+1;
		}
		      fr.close();    

		      //System.out.println(r.nom);
		      //System.out.println(r.list_ingredients);
		      //System.out.println(r.photo);
		      //System.out.println(r.saveur);
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		  }
}
