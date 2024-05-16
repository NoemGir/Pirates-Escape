package model.entities;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * 
 * Classe correspondant à la case de départ
 *
 * @author Corentin JERE
 * @author Robin MOUNIE
 */
public class StartCase extends Case{
    
    public StartCase(int number) {
        super(number, "/Start.png");
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
