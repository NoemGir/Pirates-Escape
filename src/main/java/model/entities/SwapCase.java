package model.entities;

import java.util.*;
import java.util.function.*;

public class SwapCase extends Case {

	public SwapCase(int number) {
		super(number);
                setName("Swap");
	}
	
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
