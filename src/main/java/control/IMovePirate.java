package control;

/** 
 * Les controleurs s'inscrivant à cette interface auront la possibilité de bouger un joueur
 *  
 * @author Noémie
*/
import model.entities.Pirate;

public interface IMovePirate {
        
    /**
     * Indique au controleur que le mouvement s'est terminé
     */   
    public void moveFinished();
    
    /**
     * Avance le pirate donné de la distance indiqué
     * 
     * @param pirate le pirate à bouger
     * @param distance la distance de déplacement ( en nombre de case )
     */
    public void move(Pirate pirate, int distance);
}
