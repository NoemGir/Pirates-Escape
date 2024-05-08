package boundary.graphics;




/* Premiere interface de la partie graphique
 * 
 * Rassemble toutes les méthodes 
 * implémentées par le dialogue appelées depuis le noyau fonctionnel.
 * 
 * 
 * Exemple de méthodes de l’interface IPirates : 
 * - changer le pirate en jeu,
 * - donner à l’utilisateur la possibilité de lancer les dés,
 * - afficher un message dans la zone de texte,
 * - vider la zone de texte,
 * 
 * 
 * 
 * tout ce qui est a faire dans l'IHM, ont le met dans IPirate
 * 
 * */
public interface IPirates {
	
        public void startGame();
        
        public void endGame();
        
        public String askName(int idPirate);
        
	public void changePirate(int idPirate);
        
	public void activateThrowDice();
        
        public void desactivateThrowDice();
        
	public void display(String message);
        
        public void changeHeart(int idPirate, int hp);
        
        public void movePirate(int idPirate, int box);
        
        public void movePirateAuto(int idNewPirate, int box);
}
