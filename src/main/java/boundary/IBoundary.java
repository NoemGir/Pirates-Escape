package boundary;




/*
 * Afin de pouvoir passer de la sortie textuelle à la sortie graphique nous 
 * utiliserons une interface IBoundary.
 * 
 * IBoundary contient toutes les actions que doit implémenter l’interface du noyau 
 * fonctionnel ou le boundary du jeu des pirates comme : 
 * - lancer les dés,
 * - avancer le pirate,
 * - …, 
 * 
 * 
 * 
 * difficulté : retour au backend ( void) -> faire un autre appel a methode qui va après avoir fait le boundary de retourne au back
 * 
 * 
 * tous les services qu'ont doit donner a l'utilisateur, peut importe la sortie
 * */
public interface IBoundary {
	/* affichage du lançage de dé, on lui donne le resultat*/
	/* lance les dés, puis demande au controleur via ILancerDe pour obtenir le résultat
	*/
        public void startGame();
	
	public void throwDoubleDice();
	
	public void displayPV(String pirateName, int idPirate, int health);
	
	public String askPirateName(int idPirate);
	
	public void endGame(boolean won, String pirateName, String reason);

	public void changePlayer(String name, int idPirate);

	void movePirate(String pirateName, int idPirate, String box, int boxNumber);
        
        void movePirateAuto(String pirateName, int idPirate, String box, int boxNumber);
}
