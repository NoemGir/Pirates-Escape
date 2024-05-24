/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.graphics;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import boundary.GraphicsUtils;
import boundary.graphics.personalizedComponents.PiratePawn;

/**
 * Classe créer pour générer le déplacement en glissade des pions
 * 
 * @author Noémie GIREAUD
 */
public class SlidePawn{
    
    private Dialog dialog;
    
    private PiratePawn pawn;
    private Timer timerY = new Timer(6, (ActionEvent e) -> moveY(e));
    private Timer timerX = new Timer(6, (ActionEvent e) -> moveX(e));
    private Point location;
    private Point destination;
    
    private Component casePanel;

    /**
     * Créer une instance de la classe SlidePawn
     * @param dialog le dialog
     * @param pawn le pion à glisser
     */
    public SlidePawn(Dialog dialog, PiratePawn pawn) {
        this.dialog = dialog;
        this.pawn = pawn;
    }
    
    /**
     * Glisse le pion donné jusqu'au composant indiqué
     * 
     * @param casePanel le composant vers lequel glisser le pion
     */
    public void slidePawnToComponent(Component casePanel){
        this.casePanel = casePanel;
        this.location = pawn.getLocation();
        location.translate(pawn.getSize().width/2 - pawn.getOffset(), pawn.getSize().height/2 - pawn.getOffset());
        this.destination = GraphicsUtils.computeLocationPawnInCase(casePanel);
  
        timerX.start();
        timerY.start();
    }
    
    /**
     * Décrit les actions à réaliser à la fin du timer
     */
    private void finished(){
        pawn.setBox(casePanel);
        dialog.verifyCaseMove();
    }
    
    /**
    * methode appelée par le TimerX, chargée de bouger le pion de 1 pixel
    * horizontalement dans la direction de la destination
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
                finished();
            }
        }
    }

    /**
    * methode appelée par le TimerY, chargée de bouger le pion de 1 pixel verticallement dans la direction de la destination
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
                finished();
            }
        }
    }
}
