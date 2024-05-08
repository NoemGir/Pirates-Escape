package control;

import boundary.graphics.FunctionnalKernelAdapter;
import java.util.List;
import model.entities.Case;
import model.entities.Pirate;

/* 
 *  Control lors de l'activation d'une case
 * 
 * 
 * 
 * */
public class ActivateBoxControl {
	private FunctionnalKernelAdapter functionnalKernelAdapateur = new FunctionnalKernelAdapter();
	public void activateBox(List<Pirate> listePirate,Pirate pirate, Case box) {
		box.effect().accept(listePirate, pirate);
                   functionnalKernelAdapateur.movePirateAuto(pirate.getName(),pirate.getIdPirate(), box.getName(), box.getNumber());
	}
}
