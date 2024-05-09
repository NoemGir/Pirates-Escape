package model.entities;

import java.util.function.*;
import java.util.*;

/**
 * Cette classe regroupe des méthodes pour les objets PortalCase (les case Spéciale Portail).
 * 
 * @author Corentin JERE
 * 
 */
public class PortalCase extends Case {
    /**
    * Constructeur de la classe Case.
    * 
    * @param number le numéro de la case dans le plateau.
    */
    public PortalCase(int number) {
        super(number);
        setName("Falaise");
    }
    
    /**
    * Redéfinition de la méthode effect de la classe mère Case.
    * Retourne un BiConsumer étant la fonction de l'effet de la case sur la liste des joueurs et le joueur courant, en utilisant des lambdas.
    * 
    * @return un BiConsumer étant la fonction de l'effet de la case.
    */
    @Override
    public BiConsumer<List<Pirate>, Pirate> effect(){
        return (List<Pirate> pirates, Pirate pirate) -> {
            pirate.ajustPosition( (Integer hp) -> hp + 5);			
            pirate.ajustHp( (Integer hp) -> hp - 3 );
            super.effect().accept(pirates, pirate);
        };
    }
	
    /*
    public static void main(String[] args) {
        Pirate p1 = new Pirate("p1", 5);
        Pirate p2 = new Pirate("p2", 5);
        p1.setPosition(10);
        p2.setPosition(5);

        CliffCase cliffcase = new CliffCase("cliff", 10);
        List<Pirate> pirates = new ArrayList();
        pirates.add(p1);
        pirates.add(p2);
        cliffcase.effect().accept(pirates, p1);

        System.out.println(p1.getHp());
        System.out.println(p2.getHp());
    }
    */
}
