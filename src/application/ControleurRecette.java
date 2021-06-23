package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Modele.Recette;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class ControleurRecette  {
	@FXML private Label etape;
	@FXML private Label titre;
	@FXML private TabPane tabPane;
	private Scene accueil;
	private Scene liste;
	public ControleurRecette() {
		
		
	}
	public void setScenes(Scene a, Scene b) {
		this.accueil=a;
		this.liste=b;
	}
	public void accueilScene(ActionEvent e) {
		Stage s =(Stage) tabPane.getScene().getWindow();
		s.setScene(accueil);
	}
	public void listeScene(ActionEvent e) {
		Stage s =(Stage) tabPane.getScene().getWindow();
		s.setScene(liste);
	}
	public void update(Recette r) {
		titre.setText(r.nom);
		ArrayList etapes=r.list_etapes;
		for (int i=0 ; i<etapes.size();i++) {
			Tab tab1 = new Tab("Etape "+(i+1), new Label((String) etapes.get(i)));
			tabPane.getTabs().add(tab1);
		}
	}

	
}
