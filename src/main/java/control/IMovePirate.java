package control;

/** 
 * Les controleurs s'inscrivant à cette interface auront la possibilité de bouger un joueur
 *  
 * @author Noémie
*/

public interface IMovePirate {
        
    /**
     * Indique au controleur que le mouvement s'est terminé
     */   
    public void moveFinished();
    
}
