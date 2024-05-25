package control;

import boundary.IBoundary;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import model.entities.Case;
import model.entities.Pirate;

/**
 * Control de l'activation de l'effet d'une case
 *
 * @author Robin MOUNIE
 */
public class ActivateBoxControl implements IMovePirate{

    private IBoundary boundary;
    private PirateGameControl pirateGameControl;
    private int nbPirateMoved;

    /**
     * Créer une instance de la classe ActivateBoxControl
     * @param boundary le boundary
     */
    public ActivateBoxControl(IBoundary boundary ) {
        this.boundary = boundary;
        reset();
    }

    /**
     * Réinitialise le controleur
     */
    public void reset(){
        nbPirateMoved = 0;
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

        listPirate.forEach( (Pirate p) -> positionInitialPirate.add(p.getPosition()) );

        // Ancienne version du foreach au dessus
        //for(Pirate p : listePirate){
        //    positionInitialPirate.add(p.getPosition());
        //}
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

    /**
     * Indique si il faut encore attendre la fin d'un évènement ou non
     *
     * @return
     */
    public boolean mustWait() {
        return nbPirateMoved != 0;
    }

    @Override
    public void moveFinished() {
        nbPirateMoved--;
        if(nbPirateMoved == 0){
            pirateGameControl.verifyPlayAgain();
        }
    }

    /**
     * Défini le pirateGameControl
     *
     * @param pirateGameControl
     */
    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }


}
