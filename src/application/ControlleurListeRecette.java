package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import Modele.Ingredient;
import Modele.Livre;
import Modele.Recette;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControlleurListeRecette implements Initializable{
	
	@FXML private Button btnrecherche;
	@FXML private TextField barrerecherche;
	@FXML public TableView<Recette> table;
	@FXML public TableColumn<Recette ,String> tab1;
	@FXML public TableColumn<Recette ,String> tab2;
	private Livre livre;
	private Scene Acceuil;
	private Scene nouvelleRecette;
	public VuListeRecette vuListe;
	
	public ControlleurListeRecette(Livre livre) {
		this.livre=livre;
	}

	public void getAcceuil(Scene acceuil) {
		this.Acceuil=acceuil;	
	}
	
	public void getNouvelleRecette(Scene nr) {
		this.nouvelleRecette=nr;
	}
	
	public void acceuilScene() {
		
		Stage s =(Stage) btnrecherche.getScene().getWindow();
		s.setScene(Acceuil);
	}
	public void clickcell(MouseEvent event) {
		if (event.getClickCount() == 2) {
			System.out.print(table.getSelectionModel().getSelectedItem().nom);
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
	
	public void recherche(ActionEvent event) {
		   
	   }
	
	public void update() {
		table.setItems(getRecette());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tab1.setCellValueFactory(new PropertyValueFactory<Recette,String>("nom"));
		tab2.setCellValueFactory(new PropertyValueFactory<Recette,String>("saveur"));

	
		table.setItems(getRecette());
		
		this.vuListe = new VuListeRecette(this.livre, this);
        this.livre.addObserver(this.vuListe);
	}
	
	
	
}
