/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Random;

/**
 *
 * @author Robin
 */
public class Dice {
    public Dice(){
        
    }
    public int throwDice() {
		Random ran = new Random();
        	return ran.nextInt(6)+1;
	}
    
}
