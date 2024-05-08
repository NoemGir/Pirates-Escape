package boundary;

/**
 * Afin de pouvoir passer de la sortie textuelle à la sortie graphique nous 
 * utiliserons une interface IBoundary. Elle sera accessible par les controleurs.
 * 
 * @author Noémie GIREAUD
 * 
 */
public interface IBoundary {
	
    /**
    * Commence la présentation du jeu
    */
    public void startGame();

    /**
    * Lance le visuel des deux dés
    */
    public void throwDoubleDice();

    /**
    * Affiche la vie restante du Pirate identifié
    * 
    * @param idPirate l'identifiant du pirate
    * @param health le nombre de coeur restant au pirate
    */
    public void displayPV(int idPirate, int health);

    /**
    * Demande a l'utilisateur le nom qu'il souhaite donner a son pirate
    * 
    * @param idPirate l'identifiant du pirate qui recevra le nom
    * @return le nom de pirate donné par l'utilisateur
    */
    public String askPirateName(int idPirate);

    /**
    * Montre l'affichage de fin de partie
    * 
    * @param idPirate l'identifiant du pirate qui a gagné
    * @param reason la raison de la victoire / défaite des pirates
    */
    public void endGame(int idPirate, String reason);

    /**
    * Indique le joueur auquel c'est le tour de jouer
    * 
    * @param idPirate l'identifiant du joueur qui doit jouer
    */
    public void changePlayer(int idPirate);

    /**
    * Active l'étape de déplacement du pirate
    * 
    * @param idPirate l'identifiant du joueur qui doit jouer
    * @param boxNumber le numero de la case sur laquelle il doit attérir
    */
    void movePirate(int idPirate, int boxNumber);
}
