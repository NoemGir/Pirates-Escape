package model.entities;

import java.util.function.*;
import java.util.*;

public class Case {
	private String name = "Case Normale";
	private int number;
        private String imageLink;
	
        public Case(int number) {
		this.number = number;
                this.imageLink = "";
	}
	public Case(int number,String imageLink) {
		this.number = number;
                this.imageLink = imageLink;
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
        public String getImageLink() {
		return imageLink;
	}

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    
    
}
