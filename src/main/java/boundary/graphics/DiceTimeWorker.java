/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.graphics;

import boundary.graphics.personalizedComponents.Dice;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Fabien
 */
public class DiceTimeWorker extends SwingWorker<Void,Void>{
        private Dice dice;
        private Dialog dialog;

        private int value;
        private int storedValue;
        private int nbAnimation;
        
        private Random random = new Random();

        private Timer timer = new Timer(50, (ActionEvent e) -> {timerEventHandler(e);});

        public DiceTimeWorker(Dialog dialog, Dice dice, int value){
            this.dialog = dialog;
            this.dice = dice;
            this.value =  value;
            this.storedValue = value-1;
            nbAnimation = 0;
        }

        @Override
        protected Void doInBackground() throws Exception {
            timer.start();
            return null;
        }  

        private void timerEventHandler(java.awt.event.ActionEvent e){
            if(nbAnimation < 30 + random.nextInt()%15){
                value = (random.nextInt()%7);
                nbAnimation++;
                dice.display(value);
            }else{
                value = storedValue;
                timer.stop();
                dice.display(value);
                dialog.diceFinished();
                this.cancel(true);
            }
        }
    }
