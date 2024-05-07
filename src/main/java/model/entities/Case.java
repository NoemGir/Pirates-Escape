package model.entities;

import java.util.function.*;
import java.util.*;

public class Case {
	private String name;
	private int number;
	
	public Case(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			Function<Integer, Integer> f = (Integer hp) -> hp-1;
			for (Pirate p : pirates) { 
				if ( !(p.equals(pirate)) && (p.getPosition().equals(pirate.getPosition())) ) {
					p.ajustHp(f);
					pirate.ajustHp(f);
				}
			} 
		};
	}
	
	public String getName() {
		return name;
	}
}
