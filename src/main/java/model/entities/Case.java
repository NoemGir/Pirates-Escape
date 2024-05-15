package model.entities;

import java.util.function.*;
import java.util.*;

/**
 * Cette classe regroupe des méthodes pour les objets Case (normal).
 *
 * @author Corentin JERE
 *
 */
public class Case {
    private String name = "Case Normale";
    private int number;
    private String imageLink;

    /**
    * Constructeur de la classe Case.
    *
    * @param number le numéro de la case dans le plateau.
    */
    public Case(int number) {
        this.number = number;
    }

    /**
    * Constructeur de la classe Case.
    *
    * @param number le numéro de la case dans le plateau.
    * @param imageLink le lien de l'image associée a la case
    */
    public Case(int number,String imageLink) {
                    this.number = number;
                    this.imageLink = imageLink;
    }

    /**
    * Retourne un BiConsumer étant la fonction de l'effet de la case sur la liste des joueurs et le joueur courant, en utilisant des lambdas.
    *
    * @return un BiConsumer étant la fonction de l'effet de la case.
    *
    */
    public BiConsumer<List<Pirate>, Pirate> effect(){
        return (List<Pirate> pirates, Pirate pirate) -> {
            Function<Integer, Integer> f = (Integer hp) -> hp-1;
            for (Pirate p : pirates) {
                if ( !(p.equals(pirate)) && (p.getPosition().equals(pirate.getPosition())) ) {
                    p.ajustHp(f);
                    pirate.ajustHp(f);
                }
            }
        };
    }

    /**
    * Getter du name de la case.
    *
    * @return le nom de la case.
    *
    */
    public String getName() {
        return name;
    }


    /**
    * Getter du name de la case.
    *
    * @return le nom de la case.
    *
    */
    public String getImageLink() {
                    return imageLink;
    }

    /**
    * Setter du name de la case.
    *
    * @param name le nom de la case.
    *
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Getter du number de la case.
    *
    * @return le numéro de la case sur la plateau.
    *
    */
    public int getNumber() {
        return number;
    }
}
