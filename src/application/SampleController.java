package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modele.*;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController {
		
		public Button next = null;
		public TextArea texteera = null;	
		public Label label=null; 
		public Livre livre;
		public Recette r;
   
	public SampleController() {
		this.livre= new Livre();
		this.r=new Recette();
	}
	   public void ouvrirNew(ActionEvent event) throws IOException {
	       Stage newStageRecette = new Stage();
	       newStageRecette.initModality(Modality.APPLICATION_MODAL);
	       AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("StageNewReccette.fxml"));
	        
	       
	       Scene a= new Scene(root);
	       newStageRecette.setScene(a);
	       newStageRecette.showAndWait();
	       newStageRecette.setTitle("New Recipe");
	    }
	   public void Save() throws FileNotFoundException {
		   
		   if (label.getText().equals("Nom de votre Recette :") ){
			   
			   texteera.setText("");
			   this.r.nom=texteera.getText();
			   label.setText("Saveur");
			 
		   }
		   if (label.getText().equals("Saveur")) {
			   texteera.setText("");
			   this.r.saveur=texteera.getText();
			   next.setText("Enregistrer");
			   
			   
		   }
		   if (label.getText().equals("Enregistrer")) {
			   this.livre.ajoutRecette(r);
			   this.livre.recetteToFile(r);
			   
			   texteera.setText("");
		   }
		   
		   
	   }
	}

