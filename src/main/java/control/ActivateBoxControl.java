package control;

import boundary.IBoundary;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
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
    private int pirateMoved;

    public ActivateBoxControl(IBoundary boundary ) {
        this.boundary = boundary;
    }
        
    /**
     *  Active l'effet de la case donnée
     * 
     * @param listePirate la liste des joeurs
     * @param pirate le pirate qui est tombé sur la case
     * @param box la casé dont l'effet est activé
     */
    public void activateBox(List<Pirate> listePirate, Pirate pirate, Case box) {
        
        pirateMoved = 0;
        LinkedList<Integer> positionInitialPirate = new LinkedList<>();
     
        listePirate.forEach( (Pirate p) -> positionInitialPirate.add(p.getPosition()) );
        
        // Ancienne version du foreach au dessus (juste pour montrer qu'on sait faire et que voila)
        //for(Pirate p : listePirate){
        //    positionInitialPirate.add(p.getPosition());
        //}
        
        box.effect().accept(listePirate, pirate);
        
        for(int i = 0; i<listePirate.size(); i++){
            Pirate curPirate = listePirate.get(i);
            
            if(! curPirate.getPosition().equals(positionInitialPirate.get(i))){
                pirateMoved +=1;
                System.out.println("MOVE THE PIRATE FROM CONTROL");
                boundary.movePirateAuto(curPirate.getIdPirate(), curPirate.getPosition());
            }
            boundary.displayPV(curPirate.getIdPirate(), curPirate.getHp());
        }
    }

    public boolean mustWait() {
        return pirateMoved != 0;
    }
    

    @Override
    public void moveFinished() {
        pirateMoved--;
        if(pirateMoved == 0){
            pirateMoved--;
            pirateGameControl.verifyPlayAgain();
        }
    }

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }
    
    
}
