package application;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Modele.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController {
	@FXML private Button nr;
	@FXML private Button lbr;
		 
	public Livre livre;
	public Recette r;
	public ArrayList<String> listEtape;
	public Set<Ingredient> listIngr;
	
	public SampleController() {
		this.livre= new Livre();
		this.r=new Recette();
		this.listEtape= new ArrayList<String>();
		this.listIngr= new HashSet<Ingredient>(); 
	}
	   public void pageCreation(ActionEvent event) throws IOException {
	       Stage newStageRecette = new Stage();
	       newStageRecette.initModality(Modality.APPLICATION_MODAL);
	       AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("StageNewReccette.fxml"));
	    
    
	       Scene a= new Scene(root);
	       newStageRecette.setScene(a);
	       newStageRecette.showAndWait();
	       newStageRecette.setTitle("New Recipe"); 
	    }
	   
	   @FXML private Button sauve;
	   @FXML private TextField nom;
	   @FXML private TextField saveur;
	   @FXML private TextField image;
	   @FXML private TextField ingredients;
	   @FXML private TextField etapes;
	   @FXML private Button etplus;
	   @FXML private Button ingplus;
	   @FXML private TextField mesure;
	   @FXML private TextField quantite;
	   
	   
	   public void save(ActionEvent event) throws IOException {
		   
		   this.r.nom = nom.getText();
		   this.r.saveur = saveur.getText();
		   this.r.photo = image.getText();
		   if (!etapes.getText().isEmpty()){
			   this.listEtape.add(etapes.getText());
		   }
		   if (!ingredients.getText().isEmpty()) {
			   ingplus(event);
		   }
		   this.r.list_ingredients=this.listIngr;
		   this.r.list_etapes=this.listEtape;
		   Stage stage = (Stage) sauve.getScene().getWindow();
		   stage.close();
		   this.r.recetteToFile();
		   this.listEtape.clear();
		   this.listIngr.clear();
		   this.r=new Recette();
	   }
	   

	   public void etaplus(ActionEvent event) {
		   
		   this.listEtape.add(etapes.getText());
		   etapes.clear();
	   }
	   
	   public void ingplus(ActionEvent event) {
		   Ingredient ing = new Ingredient();
		   
		   ing.mesure=mesure.getText();
		   ing.quantite=Integer.parseInt(quantite.getText());
		   ing.nom=ingredients.getText();
		   this.listIngr.add(ing);
		   ingredients.clear();
		   mesure.clear();
		   quantite.clear();
	   }
	   
	   public void pageRecettes(ActionEvent event) throws IOException {
		   Stage stage = (Stage) lbr.getScene().getWindow();
		   AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("listeRecette.fxml"));
		   Scene b = new Scene(root);
		   stage.setScene(b);

		   //boucle for sur le repertoire "Recettes", on applique la fonction fileToRecette à chaque élément pour pouvoir récup le nom des recettes qu'on affichera dans la fenetre 
		   String rep = "Recettes";
		   File file = new File(rep);
		   String chemin = file.getAbsolutePath();
		   File repertoire = new File(chemin);
		   File[] recettes = repertoire.listFiles();
		   for(int i=0; i< recettes.length; i++) {
			   //la ligne d'en dessous est à remplacer par le listing dans l'application (ici elle est dans la console)
			   System.out.println(this.livre.fileToRecette(recettes[i]).nom);
			   
		   }
	   }
		   
		   
	    
	}

