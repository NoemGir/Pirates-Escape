package model.entities;

import java.util.Random;

/**
 * Cette classe regroupe les méthodes des objets Dice.
 *
 * @author Robin MOUNIE
 * @author Corentin JERE
 */
public class Dice {
    private int displayValue = 1;
    
    /**
    * Constructeur de la classe Case.
    * 
    * @author Robin MOUNIE
    */
    public Dice(){
        
    }
    /**
    * Méthode pour obtenir le résultat du lancé du dé.
    * 
    * @author Robin MOUNIE
    * @return Le résultat du lancé du dé.
    */
    public int throwDice() {
            Random ran = new Random();
            displayValue = ran.nextInt(6)+1;
            return displayValue;
	}
    /**
    * Méthode pour récupérer le résultat du lancé de dé.
    * 
    * @author Robin MOUNIE
    * @return Le résultat du lancé du dé.
    */
    public int getDisplayValue() {
        return displayValue;
    }
}
