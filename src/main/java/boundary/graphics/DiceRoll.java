/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.graphics;

import boundary.graphics.personalizedComponents.Dice;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.Timer;

/**
 * Classe permettant de déclancher et gérer le roulement visuelle de un dé
 *
 * @author Robin MOUNIE
 */
public class DiceRoll {
        private Dice dice;
        private Dialog dialog;

        private int value;
        private int storedValue;
        private int nbAnimation;
        
        private int id;
        
        private Random random = new Random();

        private Timer timer = new Timer(50, (ActionEvent e) -> {timerEventHandler(e);});

        /**
         * Créer une instance de la classe DiceRoll
         * 
         * @param dialog le dialog
         * @param dice le dé à rouler
         * @param id le numéro identifiant le dé
         */
        public DiceRoll(Dialog dialog, Dice dice){
            this.dialog = dialog;
            this.dice = dice;
            this.id = id;
        }

        /**
         * DiceRoll : Débute le roulement du dé
         * 
         * @param value la valeure sur laquelle le dé va attérir
         */
        public void startDiceRoll(int value){
            timer.start();
            this.value =  value;
            this.storedValue = value-1;
            nbAnimation = 0;
        }  
        
        /**
         * DiceRoll : Opérations à réaliser à chaque appel du timer
         * @param e 
         */
        private void timerEventHandler(java.awt.event.ActionEvent e){
            if(nbAnimation < 30 + random.nextInt()%20){
                value = (random.nextInt()%7);
                nbAnimation++;
                dice.display(value);
            }else{
                value = storedValue;
                timer.stop();
                dice.display(value);
                dialog.display("le dé " + dice.getIdDice() + " tombe sur " + value);
                dialog.diceFinished();
            }
        }
    }
