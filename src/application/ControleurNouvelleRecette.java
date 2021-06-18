package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import Modele.Ingredient;
import Modele.Livre;
import Modele.Recette;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

public class ControleurNouvelleRecette {
	

	@FXML private Button btnsauvegarder;
	@FXML private TextField nom;
	@FXML private TextField saveur;
	@FXML private TextField ingredients;
	@FXML private TextField etapes;
	@FXML private Button etplus;
	@FXML private Button ingplus;
	@FXML private Button retour;
	@FXML private TextField mesure;
	@FXML private TextField quantite;
	@FXML private Label labelQ;
	@FXML private Label labelIng;
	@FXML private Label labelEta;
	@FXML private Label labelNom;
	@FXML private Label labelN;
	@FXML private Label labelSav;
	@FXML private Label labelEta2;
	
	private Livre livre;
	private Scene listeRecette;
	private Recette r;
	private ArrayList<String> listEtape;
	private Set<Ingredient> listIngr;
	@FXML private ImageView dragon;
	
	public ControleurListeRecette ctrlLR;
	
	private int k=0;
	private int q=0;
	
	public ControleurNouvelleRecette(Livre l) {
		this.livre=l;
		this.r=new Recette();
		this.listEtape=new ArrayList<String>();
		this.listIngr=new HashSet<Ingredient>();
		
	}
	
	public void retourListe(ActionEvent event) {
		Stage s =(Stage) retour.getScene().getWindow(); 
		s.setScene(listeRecette);
		this.dragon.setImage(null);
		k=0;
		q=0;
		labelIng.setText("");
		labelEta.setText("");
		labelN.setText("");
		labelSav.setText("");
		labelNom.setText("");
		labelEta2.setText("");
	}
	
	public void getListeRecette(Scene l) {
		this.listeRecette=l;
		
	}
	
	public void etaplus(ActionEvent event) {
		   if (!etapes.getText().isEmpty()) {
			   this.listEtape.add(etapes.getText());
			   k+=1;
			   labelEta.setText("Nombre d'étapes : " +k);
			   etapes.clear();
			   labelEta2.setText("");
		   }  
	   }
	   
	public void ingplus(ActionEvent event) {
		
		   Ingredient ing = new Ingredient();
		   boolean ok;
		   
		   if (mesure.getText().isEmpty()){
			   ing.mesure=null;  
		   }
		   
		   else ing.mesure=mesure.getText();
		   if (!ingredients.getText().isBlank()) {
			   ing.nom=ingredients.getText();
			   labelN.setText("");
		   }
		   else {
			   labelN.setText("champ obligatoire :/");
		   }
		   
		   
		   
		   if (quantite.getText().isEmpty()) {
			   labelQ.setText("Ne doit pas être vide");
			   ok=false;
			   
		   }
		   else {
			    try{
			    	ing.quantite=Integer.parseInt(quantite.getText());
			    	this.listIngr.add(ing);
			    	labelQ.setText("");
			    	ok = true;
			    }
			    catch(NumberFormatException e) {
			    	labelQ.setText("Dois être un nombre");
			    	ok = false;
			    	
		   }   
		   }

		   if(!ingredients.getText().isEmpty() && !quantite.getText().isEmpty() && ok) {
			   q+=1;
			   labelIng.setText("Nombre d'ingrédient : " +q);
			   ingredients.clear();
			   mesure.clear();
			   quantite.clear();
		   }
			   
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
	
    public void save(ActionEvent event) throws IOException {

		   
		   if (!etapes.getText().isEmpty()){
			   etaplus(event);
		   }
		   if (!ingredients.getText().isEmpty()) {
			   ingplus(event);
		   }
		   if (nom.getText().isBlank()) {
			   labelNom.setText("champ obligatoire :/");
		   }else {
			   labelNom.setText("");
		   }
		   if(saveur.getText().isBlank()) {
			   labelSav.setText("champ obligatoire :/");
		   }else {
			   labelSav.setText("");
		   }
		   if (k==0) {
			   labelEta2.setText("ajoutez 1 étape au moins");
		   }
		   if (q==0) {
			   labelN.setText("ajoutez 1 ingrédient au moins");
		   }
	   
		   if (!(nom.getText().isEmpty() || saveur.getText().isEmpty()) && this.listEtape.size()>0 && this.listIngr.size()>0) {
			   this.r.nom = nom.getText();
			   this.r.saveur = saveur.getText();
			   this.r.list_ingredients=this.listIngr;
			   this.r.list_etapes=this.listEtape;
			   if (this.dragon.getImage() == null) {
				   this.r.photo = null;
			   }
			   else {
				   String rep="src/Image/";
				   File newImage = new File(rep+nom.getText()+".png");
				   BufferedImage bi = SwingFXUtils.fromFXImage(dragon.getImage(), null);
				   ImageIO.write(bi, "png", newImage);
			   }
			   k=0;
			   q=0;
			   labelEta.setText("");
			   labelIng.setText("");
			   this.r.recetteToFile();
			   this.nom.clear();
			   this.saveur.clear();
			   this.livre.ajoutRecette(r);
			   this.listEtape.clear();
			   this.listIngr.clear();	
			   this.dragon.setImage(null);
			   this.r=new Recette();
			   this.ctrlLR.table.setItems(this.ctrlLR.getRecette());
			   Stage s =(Stage) btnsauvegarder.getScene().getWindow();
			   s.setScene(listeRecette);
		   }   
	   }
	   
	

}
