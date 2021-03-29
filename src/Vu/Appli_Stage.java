package Vu;

import Modele.Livre;
import Modele.Recette;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appli_Stage extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Le livre de recette");
        BorderPane layoutroot=new BorderPane();
        Scene scene= new Scene(layoutroot,800,600);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("Image/icon.jpg"));
        // Insertion de la barre de recherche
        HBox hbox1=new HBox();
        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(10);
        Label nom= new Label("Barre de recherche");
        nom.setPadding(new Insets(5));
        TextField recherche= new TextField();
        Button rechercher=new Button("Rechercher");
        hbox1.getChildren().addAll(nom,recherche,rechercher);
        layoutroot.setTop(hbox1);
        
        //Insertion des images-liens vers les recettes à la une
        VBox vbox2 = new VBox(8);
        vbox2.getChildren().addAll(new Label("Recettes à la une"), new Button("recette suivante")); //le bouton servira à passer à la recette suivante des recette à la une. On fait tourner 4/5 recettes.
        layoutroot.setCenter(vbox2);
        
        primaryStage.show();
        
        
        
        Livre livreRecette = new Livre();
        Recette choucrouteMelba= new Recette("Choucroute Melba","Sucré Salée");
        Recette couscous = new Recette("Couscous", "salé");
        livreRecette.ajoutRecette(choucrouteMelba);
        livreRecette.ajoutRecette(couscous);
	}

}
