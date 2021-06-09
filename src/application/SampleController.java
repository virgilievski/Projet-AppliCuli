package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
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
	   @FXML private TextField barrerecherche;
	   @FXML private Button recherche;
	   @FXML private ImageView dragon;
	   
	   
	   
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
		  
			   Stage stage = (Stage) sauve.getScene().getWindow();
			   stage.close();
			   this.r.recetteToFile();
			   this.livre.ajoutRecette(r);
			   this.listEtape.clear();
			   this.listIngr.clear();
			   this.r=new Recette();
		   
		   }
		   
		   
	   
		   
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
		   }
		   else if (ingredients.getText().isEmpty()) {
			   ingredients.setStyle("-fx-background-color: white;");
		   }
		   
		   
		   
	   }
	   
	   public ObservableList<Recette> getRecette(){
		   ObservableList<Recette> recipes = FXCollections.observableArrayList(); 
		   ArrayList<Recette> list = this.livre.liste();
	        
	       for(int i =0; i<list.size(); i++) {
	    	   recipes.add(list.get(i));
	       }
	       return recipes;
	   }
	   public void pageRecettes(ActionEvent event) throws IOException {
		   
		   Stage stage = (Stage) lbr.getScene().getWindow();
		   AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("listeRecette.fxml"));
		   Scene b = new Scene(root);
		   stage.setScene(b);
		   

		   
	       final TableView<Recette> mortecouille = new TableView<Recette>();
	       TableColumn<Recette ,String> nom = new TableColumn<Recette, String>("Nom");
	       nom.setCellValueFactory(new PropertyValueFactory<Recette, String>("nom"));
	       TableColumn<Recette ,String> saveur1 = new TableColumn<Recette, String>("Saveur");
	       saveur1.setCellValueFactory(new PropertyValueFactory<Recette, String>("saveur"));

	       mortecouille.setLayoutX(20);
	       mortecouille.setLayoutY(39);
	       mortecouille.setPrefSize(322, 533);
	       mortecouille.setEditable(true);

	        
	      
	          
	       mortecouille.setItems(getRecette());
	       mortecouille.getColumns().addAll(nom,saveur1);
	       root.getChildren().add(mortecouille); 
	       

		  
		   
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
	   
	   public void triSaveur(ActionEvent event) {
		   
	   }
	 
		   
	    
	}


