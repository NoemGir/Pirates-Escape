package control;

import boundary.IBoundary;
import java.util.LinkedList;
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
        
        LinkedList<Integer> positionInitialPirate = new LinkedList<>();
        
        for(Pirate p : listePirate){
            positionInitialPirate.add(p.getPosition());
        }
        
        box.effect().accept(listePirate, pirate);
        
        for(int i = 0; i<listePirate.size(); i++){
            if(! listePirate.get(i).getPosition().equals(positionInitialPirate.get(i))){
                boundary.movePirateAuto(listePirate.get(i).getIdPirate(), listePirate.get(i).getPosition());
            }
            boundary.displayPV(listePirate.get(i).getIdPirate(), listePirate.get(i).getHp());
        }
        
    }
}
