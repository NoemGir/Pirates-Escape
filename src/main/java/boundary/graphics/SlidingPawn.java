/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.graphics;

import boundary.GraphicsUtils;
import boundary.graphics.personalizedComponents.PiratePawn;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 * Classe créer pour genrer le déplacement en glissade des pions
 * 
 * @author Noémie GIREAUD
 */
public class SlidingPawn {
    
    private Dialog dialog;
    
    private PiratePawn pawn;
    private Timer timerY = new Timer(10, (ActionEvent e) -> {moveY(e);});
    private Timer timerX = new Timer(10, (ActionEvent e) -> {moveX(e);});
    private Point location;
    private Point destination;
    
    
    /**
    * Classe créer pour genrer le déplacement en glissade des pions
    * 
    * @author Noémie GIREAUD
    * 
    * @param pawn Le pion a faire glisser
    * @param casePanel la case vers laquelle faire glisser le pion
    */
    public void slidePawnToBox(PiratePawn pawn, Component casePanel){
        this.pawn = pawn;
        pawn.setBox(null);
        this.location = pawn.getLocation();
        location.translate(pawn.getSize().width/2 - pawn.getOffset(), pawn.getSize().height/2 - pawn.getOffset());
        System.out.println("loc = " + location);
        this.destination = GraphicsUtils.computeLocationPawnInCase(casePanel);
        timerX.start();
        timerY.start();
    }

    /**
    * Classe appelée par le TimerX, chargée de bouger le pion de 1 pixel horizontalement dans la direction de la destination
    * 
    * @author Noémie GIREAUD
    * 
    * @param e L'actionEvent ( non utilisé )
    */
    private void moveX(ActionEvent e){
        if(location.x < destination.x){
            location.translate(1, 0);
        }
        else{
            location.translate(-1, 0);
        }
        pawn.moveTo(location); 
        if(location.x == destination.x){
            timerX.stop();
            if(!timerY.isRunning()){
                dialog.verifyCaseMove();
            }
        }
    }

    /**
    * Classe appelée par le TimerY, chargée de bouger le pion de 1 pixel verticallement dans la direction de la destination
    * 
    * @author Noémie GIREAUD
    * 
    * @param e L'actionEvent ( non utilisé )
    */
    private void moveY(ActionEvent e){
        if(location.y < destination.y){
            location.translate(0, 1);
        }
        else{
            location.translate(0, -1);
        }
        pawn.moveTo(location); 
        if(location.y == destination.y){
            timerY.stop();
            if(!timerX.isRunning()){
                dialog.verifyCaseMove();
            }
        }
    }

    void setDialog(Dialog dialog) {
        this.dialog =  dialog;
    } 
}
