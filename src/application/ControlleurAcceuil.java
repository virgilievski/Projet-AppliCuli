package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlleurAcceuil {
	@FXML private Button lbr;
	@FXML private Button nr;
	private Scene listeRecette;
	private Scene nouvelleRecette;
	public ControlleurAcceuil() {

	}

	public void getScene(Scene listeRecette, Scene nouvelleRecette) {
		this.listeRecette=listeRecette;
		this.nouvelleRecette=nouvelleRecette;
		
	}
	
	public void listeRecetteScene() {
		Stage s =(Stage) nr.getScene().getWindow();
		s.setScene(listeRecette);
	}
	public void newRecetteScene() {
		
		Stage s =(Stage) nr.getScene().getWindow();
		s.setScene(nouvelleRecette);
	}

}
