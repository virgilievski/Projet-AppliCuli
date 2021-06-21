package application;

import java.net.URL;
import java.util.ResourceBundle;

import Modele.Recette;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControleurRecette implements Initializable {
	public Recette r;
	@FXML private Label etape;
	@FXML private Label titre;
	
	public ControleurRecette() {
		this.r=new Recette();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.titre.setText(r.nom);
	}
	
}
