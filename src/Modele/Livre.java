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
  
		// Créer l'objet File Reader
		FileReader fr = new FileReader(fichier);  
		// Créer l'objet BufferedReader        
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
	        //premiere ligne : on r�cup�re le nom de la recette
	        if (i==0) {
	        	r.nom=line.toString();
	      }
	        //deuxieme ligne : on r�cup�re la saveur de la recette
	        else if(i==1) {
	        	r.saveur=line.toString();
	        }
	        //troisieme ligne : on r�cup�re le set d'ingr�dient de la recette
	        else if(i==2) {
	        	//d�coupage de notre ligne avec les "/" qui d�limite chaque ingr�dient du fichier
	        	String[] parts = line.toString().split("/");
	        	//d�coupage des attributs de chaque ingr�dients d�limit�s par ","
	        	for(int j=0; j<parts.length; j++) {
	        		Ingredient ing = new Ingredient();
	        		String[] part = parts[j].split(",");
	        	//On d�finit ing puis on l'ajoute au set d'ingr�dients de la recette
	        		ing.nom=part[0];
	        		ing.quantite=Integer.parseInt(part[1]);
	        		ing.mesure=part[2];
	        		r.list_ingredients.add(ing);
	        	}
	        }
	        //quatrieme ligne : on r�cup�re la liste d'�tapes de la recette
	        else if(i==3) {
	        	//On recupere chaque �tape du fichier d�limit�e par "/"
	        	String[] parts = line.toString().split("/");
	        	//On d�finit eta en lui donnant ses attributs (num�ro de l'etape, libell� de l'etape) 
	        	//pour chaque �tape du tableau parts[]
	        	for(int j=0; j<parts.length; j++) {
	        		Etape eta = new Etape();
	        		eta.num�ro=j+1;
	        		eta.instructions=parts[j];
	        		//on ajoute l'�tape eta � la liste d'�tapes de la recette
	        		r.list_etapes.add(j, eta);;
	        	}	
		        }
	        //cinqui�me ligne : on r�cup�re le chemin de la photo
	        else if(i==4) {
		        r.photo=line.toString();
		        }
	        // i s'incr�mente � chaque nouvelle ligne lut
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
