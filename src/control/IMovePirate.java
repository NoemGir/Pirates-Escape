package control;

/*
 * Afin de pouvoir synchroniser le jeu il faut avoir des interfaces permettant 
 * de gérer les demandes du dialogue
 * 
 * IMovePirate contient toutes les actions que le noyau fonctionnel 
 * peut appeler. Les controleurs recevant ses requettes doivent 
 * implementer cette interface.
 */
public interface IMovePirate {
	public void move(String nomPirate, int value);
}
