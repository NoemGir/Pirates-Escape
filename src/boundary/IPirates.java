package boundary;




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
 * */
public interface IPirates {
	
	public void changePirate();
	public void activateThrowDice();
	public void display(String message);
	public void erase();
}
