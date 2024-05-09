package model.entities;

import java.util.function.Function;

/**
 * Cette classe regroupe des méthodes pour les objets Pirate.
 * 
 * @author Corentin JERE
 * 
 */
public class Pirate {
    private int idPirate;
    private Integer position = 0;
    private String name;
    private Integer hp;

    /**
    * Constructeur de la classe Pirate.
    * 
    * @param idPirate L'id du pirate dans le jeu.
    * @param name Le nom du pirate dans le jeu.
    * @param hp Le nombre d'hp possédé par le pirate.
    */
    public Pirate(int idPirate, String name, Integer hp) {
        this.idPirate = idPirate;
        this.name = name;
        this.hp = hp;
    }

    /**
    * Redéfinition de la méthode equals pour pouvoir comparer les pirates entre eux.
    * 
    * @param obj Un objet avec lequel sera fait la comparaison.
    * @return Un boolean étant vrai si l'égalité est juste.
    */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pirate) {
            Pirate pirate = (Pirate) obj;
            return this.name.equals(pirate.name)
                    && this.getHp().equals(pirate.getHp())
                    && this.getPosition().equals(pirate.getPosition());
        }
        return false;
    }
    
    /**
    * Méthode qui met à jour le nombre de hp du pirate selon la fonction en paramètre.
    * 
    * @param f Fonction qui sera apppliqué au hp du pirate afin d'obtenir son nouveau nombre d'hp.
    */
    public void ajustHp(Function<Integer, Integer> f) {
        this.hp = f.apply(this.hp);
        if(this.hp>5){
            this.hp = 5;
        }
        if(this.hp<0){
            this.hp = 0;
        }
    }
    /**
    * Met à jour la position du joueur sur la plateau.
    * 
    * @param f Fonction qui sera appliqué à la position du pirate afin d'obtenir sa nouvelle position.
    */
    public void ajustPosition(Function<Integer, Integer> f) {
        this.position = f.apply(this.position);
    }

    /**
    * Retour un boolean, vrai si le pirate est mort, false sinon.
    * 
    * @return Un boolean, vrai si le pirate est mort, faux sinon.
    */
    public boolean isDead() {
        return hp <= 0;
    }

    /**
    * Getter de la position du pirate (le numéro de la case où il est).
    * 
    * @return La position du pirate sur la plateau.
    */
    public Integer getPosition() {
        return position;
    }
    /**
    * Setter de la position du pirate (le numéro de la case où il est).
    * 
    * @param position La nouvelle position du joueur.
    */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
    * Getter du nombre d'hp du pirate.
    * 
    * @return Le nombre d'hp du pirate.
    */
    public Integer getHp() {
        return hp;
    }

    /**
    * Getter du nom du pirate.
    * 
    * @return Le nom du pirate.
    */
    public String getName() {
        return name;
    }
    /**
    * Setter du nom du pirate.
    * 
    * @param name Le nom du pirate.
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Getter de l'id du pirate.
    * 
    * @return L'id du pirate dans le jeu.
    */
    public int getIdPirate() {
        return idPirate;
    }
        
        

}
