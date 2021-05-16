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
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Appliculi.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("Image/icon.jpg"));
			primaryStage.show();
			primaryStage.setTitle("Culinarium");
			
		} catch(Exception e) {
			e.printStackTrace();
		}


	}
	
	public static void main(String[] args) throws IOException {
		launch(args);

		Recette pates_bolo = new Recette();
		pates_bolo.nom = "pates Bolognaise";
		pates_bolo.saveur = "sal�";
		String bouillir =  "faire bouillir les pates";
		String cuire = "chauffer la sauce bolognaise dans une poele";
		String fin =  "verser les pates dans la poele";
		pates_bolo.Ajout_etapes(bouillir);
		pates_bolo.Ajout_etapes(cuire);
		pates_bolo.Ajout_etapes(fin);
		Ingredient pates = new Ingredient("pates", 500, "g");
		Ingredient bolo = new Ingredient("bolognaise", 500, "g");
		pates_bolo.Ajout_ingredient(pates);
		pates_bolo.Ajout_ingredient(bolo);
		pates_bolo.photo = "chemin/vers/photo/bolo";
		pates_bolo.recetteToFile();

	}
	
	
}