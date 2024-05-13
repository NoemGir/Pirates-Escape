package control;




/** 
 * Les controleurs s'inscrivant à cette interface auront la possibilité de lancer les dés
 *  
 * @author Noémie
*/
public interface IThrowDice {
    
    /**
     * Obtiens le résultat du premier dé
     * @return le résultat affiché sur le premier dé
     */
    public int getFirstDiceDisplay();

    /**
     * Obtiens le résultat du second dé
     * @return le résultat affiché sur le second dé
     */
    public int getSecondDiceDisplay();

    /**
     * Indique au controleur que le lancement de dés est terminé
     */
    public void doubleDicesFinished();
}
