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
	
	
	private Scene accueil;
	private Scene listeRecette;
	private Scene nouvelleRecette;
	private Scene recette;
	private Livre livre = new Livre();
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		
        primaryStage.centerOnScreen();
		
        
        FXMLLoader accueilLoader = new FXMLLoader(getClass().getResource("Appliculi.fxml"));
        ControleurAccueil ctrlAccueil = new ControleurAccueil();
        accueilLoader.setController(ctrlAccueil);
        
        Parent accueilRoot = (Parent) accueilLoader.load();
        accueil = new Scene(accueilRoot);
        
       
        FXMLLoader listeRecetteLoader = new FXMLLoader(getClass().getResource("listeRecette.fxml"));
        ControleurListeRecette ctrlListe = new ControleurListeRecette(livre);
        listeRecetteLoader.setController(ctrlListe);
        Parent listeRecetteRoot = (Parent) listeRecetteLoader.load();
        listeRecette = new Scene(listeRecetteRoot);
     
        
        
        
        FXMLLoader nouvelleRecetteloader = new FXMLLoader(getClass().getResource("StageNewReccette.fxml"));
        ControleurNouvelleRecette ctrlNouvelleRecette = new ControleurNouvelleRecette(livre);
        nouvelleRecetteloader.setController(ctrlNouvelleRecette);
        Parent NouvelleRecetteRoot = (Parent) nouvelleRecetteloader.load();
        nouvelleRecette = new Scene(NouvelleRecetteRoot);
        
        
        FXMLLoader RecetteSceneLoader = new FXMLLoader(getClass().getResource("RecetteScene.fxml"));
        ControleurRecette ctrlRecette = new ControleurRecette();
        RecetteSceneLoader.setController(ctrlRecette);
        Parent RecetteRoot = (Parent) RecetteSceneLoader.load();
        recette = new Scene(RecetteRoot);

        ctrlListe.getScene(accueil,recette,nouvelleRecette);

        ctrlNouvelleRecette.getListeRecette(listeRecette);
        ctrlNouvelleRecette.ctrlLR=ctrlListe;
        ctrlAccueil.getScene(listeRecette,nouvelleRecette);
        ctrlListe.setCtrl(ctrlRecette);
        ctrlRecette.setScenes(accueil, listeRecette);
        
        recette.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
		accueil.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(accueil);
		primaryStage.getIcons().add(new Image("Image/icon.jpg"));
		primaryStage.show();
		primaryStage.setTitle("Culinarium");
		primaryStage.setResizable(false);	
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		}
	
	}
	
	