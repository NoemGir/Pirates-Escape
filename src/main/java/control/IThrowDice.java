package control;




/*
 * Afin de pouvoir synchroniser le jeu il faut avoir des interfaces permettant 
 * de gérer les demandes du dialogue par exemple ILancerDe. * 
 * 
 * ILancerDe contient toutes les actions que le noyau fonctionnel peut appeler.
 *  Les contrôleurs recevant ses requêtes doivent implémenter cette interface,
 *   par exemple : 
 *   - de transmettre les résultats que doivent afficher les dés,
 *   - informer que le lancer de dés est terminé afin que le contrôleur
 *   puisse poursuivre son travail.
 *  
*/

/* tous les controleurs qui ont besoin de lancer des dés, ils s'inscrivent en ILancéDé */
public interface IThrowDice {
	
	public int getFirstDiceDisplay();
        
        public int getSecondDiceDisplay();
        
        public void doubleDicesFinished();
}
