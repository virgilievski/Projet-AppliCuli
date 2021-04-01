package application;
	

import java.io.File;

import Modele.Livre;
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
	
	public static void main(String[] args) {
		launch(args);
		
		Livre bible = new Livre();
		File tiramisu = new File("Recettes/tiramisu.txt");

		System.out.println("oui");

		
		bible.fileToRecette(tiramisu);
	}
	
	
}