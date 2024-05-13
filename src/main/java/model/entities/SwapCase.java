package model.entities;

import java.util.*;
import java.util.function.*;

/**
 * Cette classe regroupe des méthodes pour les objets SwapCase (les cases spéciales swap UNO).
 *
 * @author Corentin JERE
 *
 */
public class SwapCase extends Case {
    /**
    * Constructeur de la casse SwapCase.
    *
    * @param number Le numéro de la case sur le plateau.
    */
    public SwapCase(int number) {
  		super(number,"/UNO-Reverse.png");
      setName("Swap");
  	}

    /**
    * Redéfinition de la méthode effect de la classe mère Case.
    * Retourne un BiConsumer étant la fonction de l'effet de la case sur la liste des joueurs et le joueur courant, en utilisant des lambdas.
    *
    * @return Un BiConsumer étant la fonction de l'effet de la case.
    */
    @Override
    public BiConsumer<List<Pirate>, Pirate> effect(){
        return (List<Pirate> pirates, Pirate pirate) -> {
            Iterator<Pirate> itter = pirates.iterator();
            Pirate pirateCourant = itter.next();
            Integer premierePosition = pirateCourant.getPosition();
            Pirate pirateCourant2;
            do {
                pirateCourant2 = itter.next();
                pirateCourant.setPosition(pirateCourant2.getPosition());
                pirateCourant = pirateCourant2;
            } while(itter.hasNext());
            pirateCourant2.setPosition(premierePosition);
            super.effect().accept(pirates, pirate);
        };
    }

}
