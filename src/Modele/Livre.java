package Modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Livre {
	public HashMap<String,Recette> list_recettes;
	public int nb_recette;
	
	
	public Livre() {
		this.list_recettes= new HashMap();
		this.nb_recette=0;
	}
}
