package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		
	public void txtToRecette() {
		BufferedReader lecteurAvecBuffer =null;
		String ligne;
		
	}

	public static void main(String args[]){
		try
		{
		// Le fichier d'entrée
		File file = new File("Recettes/choucrouteMelba.txt");    
		// Créer l'objet File Reader
		FileReader fr = new FileReader(file);  
		// Créer l'objet BufferedReader        
		BufferedReader br = new BufferedReader(fr);  
		StringBuffer sb = new StringBuffer();    
		String line;
		while((line = br.readLine()) != null) {
		        // ajoute la ligne au buffer
		        sb.append(line);      
		        sb.append("\n");     
		      }
		      fr.close();    
		      System.out.println("Contenu du fichier: ");
		      System.out.println(sb.toString());  
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		  }
}