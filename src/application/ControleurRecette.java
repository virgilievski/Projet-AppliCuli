package application;

import Modele.Recette;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControleurRecette {
	public Recette r;
	@FXML
	private Label etape;
	private Label titre;
	
	public ControleurRecette() {
		this.r=new Recette();
		this.titre.setText(r.nom);
	}
	
}
