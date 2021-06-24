package application;

import java.io.File;
import java.util.ArrayList;
import Modele.Recette;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ControleurRecette  {
	@FXML private Label etapas;
	@FXML private Label titre;
	@FXML private ImageView image;
	@FXML private TextField ingredients;
	@FXML private Button suivant;
	@FXML private Button precedent;

	private Scene accueil;
	private Scene liste;
	public ControleurRecette() {
		
		
	}
	public void setScenes(Scene a, Scene b) {
		this.accueil=a;
		this.liste=b;
	}
	public void accueilScene(ActionEvent e) {
		Stage s =(Stage) image.getScene().getWindow();
		s.setScene(accueil);
		
	}
	public void listeScene(ActionEvent e) {
		Stage s =(Stage) image.getScene().getWindow();
		s.setScene(liste);
	}
	public void update(Recette r) {

		titre.setText(r.nom);
		File file = new File(r.photo);
		System.out.println(file.toString());
		Image im = new Image(file.toURI().toString());
		System.out.println(im);
		image.setImage(im);
		ArrayList<?> etapes=r.list_etapes;
		etapas.setText((String) etapes.get(0));
		}
	}
	


	

