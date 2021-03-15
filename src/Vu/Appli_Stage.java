package Vu;

import javafx.application.Application;
import javafx.stage.Stage;

public class Appli_Stage extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setWidth(1024);
		primaryStage.setHeight(968);
		primaryStage.setTitle("Application Culinaire");
		primaryStage.show();
	}

}

