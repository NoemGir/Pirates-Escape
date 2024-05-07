package model.entities;

import java.util.*;
import java.util.function.*;

public class MrKrabsCase extends Case {

	public MrKrabsCase(String name, int number) {
		super(name, number);
	}
	
	@Override
	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			pirate.ajustHp( (Integer hp) -> hp + 1 );
			super.effect().accept(pirates, pirate);
		};
	}

}
