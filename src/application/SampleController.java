package application;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Modele.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
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
	       newStageRecette.setTitle("New Recipe"); 
	       newStageRecette.showAndWait();
	       
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
	   @FXML private Pagination pagination;
	   @FXML private TextArea	bruno;
	   
	   
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
	   public final ObservableList<String> names = FXCollections.observableArrayList();
	 
	   public void pageRecettes(ActionEvent event) throws IOException {
		   
		   Stage stage = (Stage) lbr.getScene().getWindow();
		   AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("listeRecette.fxml"));
		   Scene b = new Scene(root);
		   stage.setScene(b);
		   
		   
	       final TableView<String> mortecouille = new TableView<String>();
	       TableColumn<String ,String> nom = new TableColumn<String, String>("Nom");
	       mortecouille.setLayoutX(20);
	       mortecouille.setLayoutY(39);
	       mortecouille.setPrefSize(322, 533);
	       mortecouille.setEditable(true);
	       mortecouille.getColumns().addAll(nom);
	        
	       ArrayList<Recette> list = this.livre.liste();
	        
	       for(int i =0; i<list.size(); i++) {
	    	   names.add(list.get(i).nom);
	       }
	          
	       mortecouille.setItems(names);      
	       root.getChildren().add(mortecouille); 
	       

		  
		   
	   }
	 
		   
	    
	}

