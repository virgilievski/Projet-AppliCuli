package application;

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
		public Button save=null;
		public CheckBox bien = null;
		public TextField indic = null;	
		public TextArea edit =null;
		public Livre livre;
		public Recette r=new Recette();
   

	   public void ouvrirNew(ActionEvent event) throws IOException {
	       Stage newStageRecette = new Stage();
	       newStageRecette.initModality(Modality.APPLICATION_MODAL);
	       TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("StageNewReccette.fxml"));
	        
	       
	       Scene a= new Scene(root);
	       newStageRecette.setScene(a);
	       newStageRecette.showAndWait();
	       System.out.print(r.nom);
	    }
	   public void Save() {
		   
		   if (indic.getText().equals("Nom de la Recette") ){
			   
			   
			   this.r.nom=edit.getText();
			   
			 
		   }
		   
		   
	   }
	}

