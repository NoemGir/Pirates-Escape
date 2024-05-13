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
public class ActivateBoxControl implements IMovePirate{
    
    private IBoundary boundary;
    private PirateGameControl pirateGameControl;
    private int nbPirateMoved;

    public ActivateBoxControl(IBoundary boundary ) {
        this.boundary = boundary;
    }
        
    /**
     *  Active l'effet de la case donnée
     * 
     * @param listPirate la liste des joeurs
     * @param pirate le pirate qui est tombé sur la case
     * @param box la casé dont l'effet est activé
     */
    public void activateBox(List<Pirate> listPirate, Pirate pirate, Case box) {
        
        nbPirateMoved = 0;
        LinkedList<Integer> positionInitialPirate = new LinkedList<>();
     
        for(Pirate p : listPirate){
            positionInitialPirate.add(p.getPosition());
        }
        
        box.effect().accept(listPirate, pirate);
        
        for(int i = 0; i<listPirate.size(); i++){
            Pirate curPirate = listPirate.get(i);
            
            if(! curPirate.getPosition().equals(positionInitialPirate.get(i))){
                nbPirateMoved +=1;
                boundary.movePirateAuto(curPirate.getIdPirate(), curPirate.getPosition());
            }
            boundary.displayPV(curPirate.getIdPirate(), curPirate.getHp());
        }
    }

    public boolean mustWait() {
        return nbPirateMoved != 0;
    }
    

    @Override
    public void moveFinished() {
        nbPirateMoved--;
        if(nbPirateMoved == 0){
            nbPirateMoved--;
            pirateGameControl.verifyPlayAgain();
        }
    }

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }
    
    
}
