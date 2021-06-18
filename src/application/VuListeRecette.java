package application;

import java.util.Observable;
import java.util.Observer;

import Modele.Livre;
import javafx.scene.control.TableView;

public class VuListeRecette implements Observer  {
	private Livre livre;
	private ControleurListeRecette ctrl;
	private TableView table;


public VuListeRecette(Livre l, ControleurListeRecette ctrl) {
	this.livre=l;
	this.ctrl=ctrl;
	this.table=ctrl.table;
}


@Override
public void update(Observable o, Object arg) {
	System.out.print("oui");
	table.setItems(this.ctrl.getRecette());
	
}
}