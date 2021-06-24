package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
	@FXML private Label titreEtape;
	@FXML private Label titre;
	@FXML private ImageView image;
	@FXML private Label ingredients;
	@FXML private Button suivant;
	@FXML private Button precedent;

	public Recette rec ;
	public int a = 0;
	private Scene accueil;
	private Scene liste;
	public ControleurRecette() {
		
		
	}
	public void setScenes(Scene a, Scene b) {
		this.accueil=a;
		this.liste=b;
	}
	public void accueilScene(ActionEvent e) {
		a=0;
		Stage s =(Stage) image.getScene().getWindow();
		s.setScene(accueil);
		
	}
	public void listeScene(ActionEvent e) {
		a=0;
		Stage s =(Stage) image.getScene().getWindow();
		s.setScene(liste);
	}
	public void update(Recette r) {
		
		titreEtape.setText("Etape "+(a+1)+":");


		rec = r;
		titre.setWrapText(true);
		titre.setText(r.nom);
		File file = new File(r.photo);
		Image im = new Image(file.toURI().toString());
		
		image.setImage(im);
		ArrayList<String> etapes=r.list_etapes;
		etapas.setWrapText(true);
		etapas.setText(r.list_etapes.get(a));
		
		ingredients.setWrapText(true);
		
		String ing="";
		for (Map.Entry mapentry : r.list_ingredients.entrySet()) {
			ing+=(r.list_ingredients.get(mapentry.getKey()).toString())+"\n"; 
			
	                             
	        }
		this.ingredients.setText(ing);
		}
		
	public void suiv(ActionEvent e){

		ArrayList<?> etapes=rec.list_etapes;

		try {
			a+=1;
			etapas.setWrapText(true);
			etapas.setText((String) etapes.get(a));
			titreEtape.setText("Etape "+(a+1)+":");
		}catch(IndexOutOfBoundsException c) {
			a=etapes.size()-1;
		}
	}
	public void prec(ActionEvent e) {
		try {
			a-=1;
			etapas.setWrapText(true);
			ArrayList<?> etapes=rec.list_etapes;
			etapas.setText((String) etapes.get(a));
			titreEtape.setText("Etape "+(a+1)+":");
		}catch(IndexOutOfBoundsException c) {
			a=0;
		}
	}
}
	



