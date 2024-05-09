package model.entities;

import java.util.*;
import java.util.function.*;

/**
 * Cette classe regroupe des méthodes pour les objets GargamelleCase (les cases spéciales Gargamelle des Shtroumpfs).
 * 
 * @author Corentin JERE
 * 
 */
public class GargamelleCase extends Case {
    /**
    * Constructeur de la classe GargamelleCase.
    * 
    * @param number Le numéro de la case sur le plateau.
    */
    public GargamelleCase(int number) {
        super(number);
        setName("Gargamelle");
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
            pirate.ajustHp( (Integer hp) -> hp - 1);
            super.effect().accept(pirates, pirate);
        };
    }
}
