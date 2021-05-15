package application;

import java.io.FileNotFoundException;

import java.io.IOException;

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
		
	public SampleController() {
		this.livre= new Livre();
		this.r=new Recette();
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
	   
	   public void save(ActionEvent event) throws IOException {
		   this.r.nom = nom.getText();
		   this.r.saveur = saveur.getText();
		   this.r.photo = image.getText();
		   
		   
		  // this.r.recetteToFile();
	   }
	   
	   @FXML private TextField ingredients;
	   @FXML private TextField etapes;
	   @FXML private Button etplus;
	   @FXML private Button ingplus;
	   
	   public void etaplus(ActionEvent event) {
		   //l'idée sera de créer une liste qui s'injectera dans this.r.etape au lancement de la fonction save
	   }
	   
	   public void ingplus(ActionEvent event) {
		   //idem que etaplus
	   }
	   
	   public void pageRecettes(ActionEvent event) {
		   
	   }
		   
		   
	    
	}

