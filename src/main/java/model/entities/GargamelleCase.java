package model.entities;

import java.util.*;
import java.util.function.*;

public class GargamelleCase extends Case {

	public GargamelleCase(int number) {
		super(number,"/Gargamel.png");
                setName("Gargamelle");
	}

	@Override
	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			pirate.ajustHp( (Integer hp) -> hp - 1);
			super.effect().accept(pirates, pirate);
		};
	}
	
}
