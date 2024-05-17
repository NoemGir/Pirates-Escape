package model.entities;

import java.util.*;
import java.util.function.*;

/**
 * Cette classe regroupe des méthodes pour les objets LuckyLukeShadowCase (les cases spéciales de l'ombre de lucky luke).
 *
 * @author Corentin JERE
 */
public class LuckyLukeShadowCase extends Case {
    /**
    * Constructeur de la classe LuckyLukeShadowCase.
    *
    * @param number Le numéro de la case sur le plateau.
    */
    public LuckyLukeShadowCase(int number) {
        super(number,"/LuckyLuck.png");
        setName("Lucky Luke Shadow");
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
            pirate.ajustHp( (Integer hp) -> hp - 2 );
            super.effect().accept(pirates, pirate);
        };
    }
}
