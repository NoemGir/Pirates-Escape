package control;

import boundary.IBoundary;
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
    
    private IBoundary boundary;

    public ActivateBoxControl(IBoundary boundary) {
        this.boundary = boundary;
    }
        
    public void activateBox(List<Pirate> listePirate,Pirate pirate, Case box) {
        box.effect().accept(listePirate, pirate);
        boundary.movePirateAuto(pirate.getIdPirate(), box.getNumber());
    }
}
