package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		String nom = null;
		String saveur = null;
		Recette r = new Recette(nom, saveur);
		while((line = br.readLine()) != null) {
		        // ajoute la ligne au buffer
		        sb.append(line);      
		        sb.append("\n");     
		      }
		      fr.close();    
		      System.out.println("Contenu du fichier: ");
		      System.out.println(sb);  
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		  }
}
