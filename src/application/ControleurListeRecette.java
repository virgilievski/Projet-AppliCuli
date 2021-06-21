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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControleurListeRecette implements Initializable{
	
	@FXML private Button btnrecherche;
	@FXML private TextField barrerecherche;
	@FXML public TableView<Recette> table;
	@FXML public TableColumn<Recette ,String> tab1;
	@FXML public TableColumn<Recette ,String> tab2;

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
		if (event.getClickCount() == 2) {
			s.setScene(recetteScene);
			ctrlR.update(table.getSelectionModel().getSelectedItem());
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
		table.setItems(recherche());
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tab1.setCellValueFactory(new PropertyValueFactory<Recette,String>("nom"));
		tab2.setCellValueFactory(new PropertyValueFactory<Recette,String>("saveur"));
		

	
		table.setItems(getRecette());
		
		
        
	}
	
	
	
}
