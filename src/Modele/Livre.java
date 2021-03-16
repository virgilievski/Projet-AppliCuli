package Modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Livre {
	public HashMap<Integer,Recette> dico_recettes;
	public int nb_recettes;
	
	
	public Livre() {
		this.dico_recettes= new HashMap();
		this.nb_recettes=0;
	}
	
	public void ajoutRecette(Integer ID_recette, Recette r) {
		this.dico_recettes.put(ID_recette, r);
		this.nb_recettes+=1;
	}
}
