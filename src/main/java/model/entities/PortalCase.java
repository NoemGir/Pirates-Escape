package model.entities;

import java.util.function.*;
import java.util.*;

/**
 * Cette classe regroupe des méthodes pour les objets PortalCase (les case Spéciale Portail).
 * 
 * @author Corentin JERE
 */
public class PortalCase extends Case {
    /**
    * Constructeur de la classe Case.
    * 
    * @param number le numéro de la case dans le plateau.
    */
    public PortalCase(int number) {
        super(number, "/portal.png");
        setName("Trou noir");
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
            pirate.ajustPosition( (Integer position) -> position + 5);			
            pirate.ajustHp( (Integer hp) -> hp - 3 );
            super.effect().accept(pirates, pirate);
        };
    }
}
