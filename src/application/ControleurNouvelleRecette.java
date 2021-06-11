package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import Modele.Ingredient;
import Modele.Livre;
import Modele.Recette;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControleurNouvelleRecette {
	@FXML private Button btnsauvegarder;
	@FXML private TextField nom;
	@FXML private TextField saveur;
	@FXML private TextField ingredients;
	@FXML private TextField etapes;
	@FXML private Button etplus;
	@FXML private Button ingplus;
	@FXML private TextField mesure;
	@FXML private TextField quantite;
	private Livre livre;
	private Scene listeRecette;
	private Recette r;
	private ArrayList<String> listEtape;
	private Set<Ingredient> listIngr;
	@FXML private ImageView dragon;
	
	public ControleurNouvelleRecette(Livre l) {
		this.livre=l;
		this.r=new Recette();
		this.listEtape=new ArrayList();
		this.listIngr=new HashSet();
	}
	
	public void getListeRecette(Scene l) {
		this.listeRecette=l;
		
	}
	
	public void etaplus(ActionEvent event) {
		   if (!etapes.getText().isEmpty()) {
			   this.listEtape.add(etapes.getText());
			   etapes.clear();
		   }  
	   }
	   
	public void ingplus(ActionEvent event) {
		
		   Ingredient ing = new Ingredient();
		   
		   if (mesure.getText().isEmpty()){
			   ing.mesure=null;  
		   }
		   
		   else ing.mesure=mesure.getText();
		   
		   if (!(ingredients.getText().isEmpty() || quantite.getText().isEmpty())) {
			   ing.nom=ingredients.getText();
			   ing.quantite=Integer.parseInt(quantite.getText());
			   this.listIngr.add(ing);
			   ingredients.clear();
			   mesure.clear();
			   quantite.clear();
			   quantite.setStyle("-fx-background-color: green;");
			   ingredients.setStyle("-fx-background-color: green;");
			   mesure.setStyle("-fx-background-color: green;");
			   
		   }
		   else {
			   if (ingredients.getText().isEmpty()) {
				   ingredients.setStyle("-fx-background-color: red;"); 
			   
			   }
			   
			   if (quantite.getText().isEmpty()) {
			   quantite.setStyle("-fx-background-color: red;");
			   }
		   }
		      
	   }
	@FXML
	private void handledragover(DragEvent event) {
		if(event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.ANY);
			}
	    }
	   
	@FXML
	private void handledrop(DragEvent event) throws FileNotFoundException {
		List<File> files = event.getDragboard().getFiles();
		Image img = new Image(new FileInputStream(files.get(0)));
		dragon.setImage(img);
	    }
	
    public void save(ActionEvent event) throws IOException {

		   
		   if (!etapes.getText().isEmpty()){
			   etaplus(event);
		   }
		   if (!ingredients.getText().isEmpty()) {
			   ingplus(event);
		   }		   
	   
		   if (!(nom.getText().isEmpty()) || saveur.getText().isEmpty() && this.listEtape.size()>0 && this.listIngr.size()>0) {
			   this.r.nom = nom.getText();
			   this.r.saveur = saveur.getText();
			   this.r.list_ingredients=this.listIngr;
			   this.r.list_etapes=this.listEtape;
			   String rep="src/Image/";
			   File newImage = new File(rep+nom.getText()+".png");
			   BufferedImage bi = SwingFXUtils.fromFXImage(dragon.getImage(), null);
			   ImageIO.write(bi, "png", newImage);
			   this.r.recetteToFile();
			   this.nom.clear();
			   this.saveur.clear();
			   this.livre.ajoutRecette(r);
			   this.listEtape.clear();
			   this.listIngr.clear();
			   this.r=new Recette();
			   
			   Stage s =(Stage) btnsauvegarder.getScene().getWindow();
			   s.setScene(listeRecette);
		   }   
	   }
	   
	

}
