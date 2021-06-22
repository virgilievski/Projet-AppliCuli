package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

import Modele.Ingredient;
import Modele.Livre;
import Modele.Recette;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControleurListeRecette implements Initializable{
	
	@FXML private Button btnrecherche;
	@FXML private TextField barrerecherche;
	@FXML public TableView<Recette> table;
	@FXML public TableColumn<Recette ,String> tab1;
	@FXML public TableColumn<Recette ,String> tab2;
	@FXML public Button btnsup;
	private Livre livre;
	private Scene Accueil;
	private Scene nouvelleRecette;
	private Scene recetteScene;
	private ControleurRecette ctrlR;
	
	public ControleurListeRecette(Livre livre) {
		this.livre=livre;
	}
	
	public void getScene(Scene accueil,Scene r,Scene nr) {
		this.Accueil=accueil;	
		this.recetteScene=r;
		this.nouvelleRecette=nr;
	}
	
	public void setCtrl(ControleurRecette r) {
		this.ctrlR=r;
	}
	
	public void accueilScene() {
		
		Stage s =(Stage) btnrecherche.getScene().getWindow();
		s.setScene(recetteScene);
		
	}
	public void clickcell(MouseEvent event) throws IOException {
		Stage s =(Stage) btnrecherche.getScene().getWindow();
		
		btnsup.setVisible(false);
		if (event.getClickCount() == 2 && !table.getSelectionModel().isEmpty() && event.getButton()==MouseButton.PRIMARY) {
			s.setScene(recetteScene);
			ctrlR.update(table.getSelectionModel().getSelectedItem());
		}
		else if (!table.getSelectionModel().isEmpty() && event.getButton()==MouseButton.SECONDARY){
			btnsup.setVisible(true);
			btnsup.setLayoutX(event.getSceneX());
			btnsup.setLayoutY(event.getSceneY()-10);
		}
	}
	public void nouvelleRecetteScene() {
		Stage s =(Stage) btnrecherche.getScene().getWindow(); 
		s.setScene(nouvelleRecette);
		
	}
	
	public ObservableList<Recette> getRecette(){
		ObservableList<Recette> recipes = FXCollections.observableArrayList(); 
		ArrayList<Recette> list = this.livre.liste();
	        
	    for(int i =0; i<list.size(); i++) {
	    	recipes.add(list.get(i));
	        }
	    return recipes;
	    }
	
	public ObservableList<Recette> recherche() {
		   String motRecherche= barrerecherche.getText();
		   ObservableList<Recette> recipes = FXCollections.observableArrayList();
		   for (String key : this.livre.dico_recettes.keySet()) {
			   //System.out.println(key.length());
			   //System.out.println(motRecherche.length());

			   if (key.equals(motRecherche)) {
				   
				   recipes.add(this.livre.dico_recettes.get(key));
			   }
			   else if (this.livre.dico_recettes.get(key).list_ingredients.containsKey(motRecherche)) {
				   recipes.add(this.livre.dico_recettes.get(key));
			   }
			   
			   
			}
		   return recipes;
	   }
	public void setUpRecherche(ActionEvent event) {
		btnsup.setVisible(false);
		table.setItems(recherche());
	}
	
	public void supprimerRecette(ActionEvent event) throws IOException {
		this.livre.supprimerRecette(table.getSelectionModel().getSelectedItem());
		btnsup.setVisible(false);
		table.setItems(getRecette());;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tab1.setCellValueFactory(new PropertyValueFactory<Recette,String>("nom"));
		tab2.setCellValueFactory(new PropertyValueFactory<Recette,String>("saveur"));
		

	
		table.setItems(getRecette());
		
		
        
	}
	
	
	
}
