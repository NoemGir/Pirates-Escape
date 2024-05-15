/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * 
 * Classe correspondant à la case de départ
 *
 * @author Robin
 */
public class StartCase extends Case{
    
    public StartCase(int number) {
        super(number, "/Start.png");
    }
    @Override
	public BiConsumer<List<Pirate>, Pirate> effect(){
		return (List<Pirate> pirates, Pirate pirate) -> {
			pirate.ajustPosition( (Integer hp) -> hp);			
			pirate.ajustHp( (Integer hp) -> hp);
			super.effect().accept(pirates, pirate);
		};
	}
}
