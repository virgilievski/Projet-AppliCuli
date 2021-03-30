package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
	   public void rotate() {
		   bien.setRotate(bien.getRotate()+1);
	   }
	   
	   public void ouvrirNew(ActionEvent event) throws IOException {
	       Stage newStageRecette = new Stage();
	       newStageRecette.initModality(Modality.APPLICATION_MODAL);
	       AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("StageNewReccette.fxml"));
	       //VBox root = new VBox(20);
	       Scene a= new Scene(root);
	       newStageRecette.setScene(a);
	       newStageRecette.showAndWait();
	    }
	   public void Save() {
		   indic.setText("saveur");
		   
	   }
	}

