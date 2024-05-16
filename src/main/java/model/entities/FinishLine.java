package model.entities;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Classe correspondant à la case d'arrivée
 *
 * @author Corentin JERE
 * @author Robin MOUNIE
 */
public class FinishLine extends Case{

    public FinishLine(int number) {
        super(number, "/Sunny.png");
    }

    @Override
    public BiConsumer<List<Pirate>, Pirate> effect(){
        return (List<Pirate> pirates, Pirate pirate) -> {
            pirate.ajustPosition( (Integer position) -> position);
            pirate.ajustHp( (Integer hp) -> hp);
            super.effect().accept(pirates, pirate);
        };
    }
}
