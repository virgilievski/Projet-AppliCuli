package Vu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        HBox hbox1=new HBox();
        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(10);
        Label nom= new Label("Barre de recherche");
        nom.setPadding(new Insets(5));
        TextField recherche= new TextField();
        Button rechercher=new Button("Rechercher");
        hbox1.getChildren().addAll(nom,recherche,rechercher);
        layoutroot.setTop(hbox1);
        primaryStage.show();
	}

}
