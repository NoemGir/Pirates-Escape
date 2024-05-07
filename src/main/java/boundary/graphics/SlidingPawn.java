/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.graphics;

import boundary.graphics.personalizedComponents.CasePanel;
import boundary.graphics.personalizedComponents.PiratePawn;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author noemi
 */
public class SlidingPawn {
    
    private Dialog dialog;
    
    private PiratePawn pawn;
    private Timer timerY = new Timer(10, (ActionEvent e) -> {moveY(e);});
    private Timer timerX = new Timer(10, (ActionEvent e) -> {moveX(e);});
    private Point location;
    private Point destination;
    
    
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
