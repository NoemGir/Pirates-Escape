package model.entities;

import java.util.*;
import java.util.function.*;

/**
 * Cette classe regroupe des méthodes pour les objets NurseCase (Les cases spéciales Infermière Joelle).
 *
 * @author Corentin JERE
 *
 */
public class NurseCase extends Case {
    /**
    * Constructeur de la classe NurseCase.
    *
    * @param number Le numéro de la case sur le plateau.
    */
    public NurseCase(int number) {
  		super(number,"/Joelle.png");
      setName("Nurse");
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
            pirate.ajustHp( (Integer hp) -> hp + 2 );
            super.effect().accept(pirates, pirate);
        };
    }
}
