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
*/
public interface IBoundary {

	public void throwDice();
	public void movePirate(int idPlayer);
	
}
