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
	
	public void throwDice1(int display);
	public void throwDice2(int display);
	
	/* seul le jeton qui corrrspond a au pirate actel peut etre déplacé, et il doit etre glissé*/
	/* en console : le pirate tant bouge jusqu'a la case tant  */
	
	public void displayPV(String pirateName, int health);
	
	public String askPirateName();
	
	public void endGame(boolean won, String pirateName, String reason);

	public void changeTurn(String name);

	void movePirate(String pirateName, String box);
}