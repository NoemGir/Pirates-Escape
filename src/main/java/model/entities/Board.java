package model.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Cette classe regroupe des méthodes pour les objets Board (plateau).
 * 
 * @author Robin MOUNIE
 * @author Corentin JERE
 */
public class Board{
    private int nbCase;
    private LinkedList<Pirate> listPirate = new LinkedList<>();
    private List<Case> cases = new LinkedList<>();

    /**
    * Constructeur de la classe Board (plateau).
    * 
    * @author Robin MOUNIE
    * 
    * @param nbCase Le numéro de la case sur le plateau.
    */
    public Board(int nbCase) {
        this.nbCase = nbCase;
    }

    /**
    * Méthode permettant de changer la position d'un pirate sur le plateau.
    * 
    * @author Robin MOUNIE
    * 
    * @param pirate Le nom du pirate à déplacer.
    * @param distance La distance entre la case actuelle et la destination.
    * @return La case destination une fois le déplacement fait.
    */
    public Case move(String pirate, int distance) {
        int position = getPlayer(pirate).getPosition();
        int destination = position + distance;
        if(destination < this.nbCase){
            getPlayer(pirate).setPosition(destination);
        }else{
            getPlayer(pirate).setPosition(2*(this.nbCase-1)-distance-position);
        }
        return cases.get(getPlayer(pirate).getPosition());
    }
    
    /**
    * Méthode retournant la position d'un pirate.
    * 
    * @author Robin MOUNIE
    * 
    * @param pirate Le nom du pirate visé.
    * @return La position du pirate visé sur le plateau.
    */
    public int getLocationPlayer(String pirate) {
        return getPlayer(pirate).getPosition();
    }
    
    /**
    * Mathode pour ajouter un joueur au plateau.
    * 
    * @author Robin MOUNIE
    * 
    * @param player Le pirate à ajouté
    */
    public void addPlayer(Pirate player) {
        listPirate.add(player);
    }
    /**
    * Méthode pour obtenir un pirate avec son nom. 
    * 
    * @author Robin MOUNIE
    * 
    * @param playerName Le nom du pirate visé
    * @return Le pirate visé (ou null s'il n'est pas trouvé)
    */
    public Pirate getPlayer(String playerName) {
        for(Pirate p : listPirate){
            if(p.getName().equals(playerName)){
                return p;
            }
        }
        return null;
    }
    
    /**
    * Getter de listPirate, la liste des pirates sur le plateau.
    * 
    * @author Robin MOUNIE
    * 
    * @return La liste des pirates sur le plateau.
    */
    public LinkedList<Pirate> getListPirate() {
        return listPirate;
    }
       
    /**
    * Getter du nbCase, le nombre de case du plateau.
    * 
    * @author Robin MOUNIE
    * 
    * @return Le nombre de case sur le plateau.
    */
    public int getNbCase() {
        return nbCase;
    }
    
    /**
    * Méthode pour ajouter une case au plateau.
    * 
    * @author Robin MOUNIE
    * 
    * @param box la case à ajouter au plateau.
    */
    public void addCase(Case box) {
        cases.add(box);
    }
    /**
    * Getter de cases, la liste des cases du plateau.
    * 
    * @author Robin MOUNIE
    * 
    * @return La liste des cases sur le plateau.
    */
    public List<Case> getCases() {
        return cases;
    }
}
