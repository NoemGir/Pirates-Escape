package boundary.graphics;



/* Deuxième interface de la partie Graphique
 * 
 * L’interface INoyauFonctionnel rassemble toutes les méthodes 
 * implémentées par le noyau fonctionnel appelées depuis le dialogue.
 * 
 * 
 * Exemple de méthodes de l’interface 
 * INoyauFonctionnel : 
 * - de demander les chiffres que doivent afficher les dés,
 * - informer que le lancer de dés est terminé,
 * - les noms des pirates
 * 
 * */
public interface IFunctionnalKernel {
	
	public void getNumberOnDice();
	public void diceFinished();
	public void getPirateNames();
}
