package boundary.graphics;

import java.util.LinkedList;

/** 
 * Rassemble toutes les méthodes 
 * implémentées par le noyau fonctionnel appelées depuis le dialogue.
 * 
 * @author Noémie GIREAUD
 */
public interface IFunctionnalKernel {
    
    /** 
    * Donne le nombre affiché par le dés identifié
    * 
    * @param idDice l'identifiant du dé
    * @return le nombre affiché par le dé
    */
    public int getNumberOnDice(int idDice);

    /** 
    * Indique au controleur que le lancé des deux dés est terminé
    */
    public void diceFinished();

    /** 
    * Indique au controleur que le mouvement du pion à bien été réalisé
    */
    public void moveFinished();

    /** 
    * Indique au controleur que le mouvement du pion résultant de l'effet d'une case à 
    * bien été réalisé
    */
    public void moveEffectFinished();
    
    /** 
    * Récupère le nom du pirate identifié
    * 
    * @param idPirate l'identifiant du pirate
    * @return le nom du pirate
    */
    public String getPirateName(int idPirate);
    
    /** 
    * Récupère le nom de la case identifié
    * 
    * @param idCase l'identifiant de la case
    * @return le nom de la case
    */
    public String getCaseName(int idCase);
    /** 
    * Récupère le lien de l'image de la case identifié
    * 
    * @return le nom de la case
    */
    public LinkedList<String> getCaseImageLinks();
    
    /**
     * Permet de recommencer une partie
     */
    public void playAgain();

}