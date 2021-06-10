package application;
	

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

import Modele.Etape;
import Modele.Ingredient;
import Modele.Livre;
import Modele.Recette;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	private Scene acceuil;
	private Scene listeRecette;
	private Scene nouvelleRecette;
	private Livre livre = new Livre();
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		
        primaryStage.centerOnScreen();
		
        
        FXMLLoader acceuilLoader = new FXMLLoader(getClass().getResource("Appliculi.fxml"));
        ControlleurAcceuil ctrlAcceuil = new ControlleurAcceuil();
        acceuilLoader.setController(ctrlAcceuil);
        
        Parent acceuilRoot = (Parent) acceuilLoader.load();
        acceuil = new Scene(acceuilRoot);
        
       
        FXMLLoader listeRecetteLoader = new FXMLLoader(getClass().getResource("listeRecette.fxml"));
        ControlleurListeRecette ctrlListe = new ControlleurListeRecette(livre);
        listeRecetteLoader.setController(ctrlListe);
        Parent listeRecetteRoot = (Parent) listeRecetteLoader.load();
        listeRecette = new Scene(listeRecetteRoot);
     
        ctrlListe.getAcceuil(acceuil);
        
        
        FXMLLoader nouvelleRecetteloader = new FXMLLoader(getClass().getResource("StageNewReccette.fxml"));
        ControleurNouvelleRecette ctrlNouvelleRecette = new ControleurNouvelleRecette(livre);
        nouvelleRecetteloader.setController(ctrlNouvelleRecette);
        Parent NouvelleRecetteRoot = (Parent) nouvelleRecetteloader.load();
        nouvelleRecette = new Scene(NouvelleRecetteRoot);
        
        
        ctrlNouvelleRecette.getListeRecette(listeRecette);
        
        ctrlAcceuil.getScene(listeRecette,nouvelleRecette);
        ctrlListe.getNouvelleRecette(nouvelleRecette);
        
        
        
		acceuil.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(acceuil);
			primaryStage.getIcons().add(new Image("Image/icon.jpg"));
			primaryStage.show();
			primaryStage.setTitle("Culinarium");
			primaryStage.setResizable(false);	
		
		


	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		}
	
	}
	
	