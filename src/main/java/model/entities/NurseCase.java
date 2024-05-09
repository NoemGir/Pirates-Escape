package model.entities;

import java.util.*;
import java.util.function.*;

public class NurseCase extends Case {

	public NurseCase(int number) {
		super(number,"/Joelle.png");
                setName("Nurse");
	}
	
	@Override
	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			pirate.ajustHp( (Integer hp) -> hp + 2 );
			super.effect().accept(pirates, pirate);
		};
	}

}
