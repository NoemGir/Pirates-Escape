package model.entities;

import java.util.function.*;
import java.util.*;

public class CliffCase extends Case {
		
	/**
	* @param number
	* @param destination
	*/
	public CliffCase(int number) {
		super(number);
                setName("Falaise");
	}
	
	@Override
	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			pirate.ajustPosition( (Integer hp) -> hp + 5);			
			pirate.ajustHp( (Integer hp) -> hp - 3 );
			super.effect().accept(pirates, pirate);
		};
	}
	
	/*
	public static void main(String[] args) {
		Pirate p1 = new Pirate("p1", 5);
		Pirate p2 = new Pirate("p2", 5);
		p1.setPosition(10);
		p2.setPosition(5);
		
		CliffCase cliffcase = new CliffCase("cliff", 10);
		List<Pirate> pirates = new ArrayList();
		pirates.add(p1);
		pirates.add(p2);
		cliffcase.effect().accept(pirates, p1);
		
		System.out.println(p1.getHp());
		System.out.println(p2.getHp());
	}
	*/
	
	
	
	
	
	
	
	
	
	
	//protected Case arrivee(Oie oie) {
	//	oie.ajouterMessage("La case "+this.getNom()+" ammene l'Oie "+oie.getCouleur()+" a la case "+oie.getPlateau().donnerCase(destination).getNom());
	//	return oie.getPlateau().donnerCase(destination);
	//}

}
