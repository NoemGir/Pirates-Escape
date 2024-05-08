package boundary.graphics;




/**
 * 
 * Rassemble toutes les méthodes implémentées par le dialogue appelées depuis le noyau fonctionnel.
 * 
 * @author Noémie GIREAUD
 * 
 * */
public interface IPirates {
	
    /**
    * Commence la présentation du jeu
    */
    public void startGame();

    /**
    * Montre l'affichage de fin de partie
    * TODO
    */
    public void endGame();

    /**
    * Demande a l'utilisateur le nom qu'il souhaite donner a son pirate
    * 
    * @param idPirate l'identifiant du pirate qui recevra le nom
    * @return le nom de pirate donné par l'utilisateur
    */
    public String askName(int idPirate);

    /**
    * Indique le joueur auquel c'est le tour de jouer
    * 
    * @param idPirate l'identifiant du joueur qui doit jouer
    */
    public void changePirate(int idPirate);

    /**
    * Active la possibilité de jeter les dés
    */
    public void activateThrowDice();

    /**
    * Sésactive la possibilité de jeter les dés
    */
    public void desactivateThrowDice();

    /**
    * Ajoute le message dans le display du jeu
    * 
    * @param message Le message à ajouter
    */
    public void display(String message);

    /**
    * Affiche la vie restante du Pirate identifié
    * 
    * @param idPirate l'identifiant du pirate
    * @param hp le nombre de coeur restant au pirate
    */
    public void changeHeart(int idPirate, int hp);

    /**
    * Rend le déplacement du pirate possible 
    * 
    * @param idPirate l'identifiant du joueur qui doit jouer
    * @param box le numero de la case sur laquelle il doit attérir
    */
    public void movePirate(int idPirate, int box);
}
