package model.entities;

import java.util.*;
import java.util.function.*;

public class LuckyLukeShadowCase extends Case {

	public LuckyLukeShadowCase(String name, int number) {
		super(name, number);
	}
	
	@Override
	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			pirate.ajustHp( (Integer hp) -> hp - 2 );
			super.effect().accept(pirates, pirate);
		};
	}

}
