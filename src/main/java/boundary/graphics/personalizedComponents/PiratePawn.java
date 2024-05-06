/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics.personalizedComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author noemi
 */
public class PiratePawn extends javax.swing.JPanel {
    private boolean activated;
    private int offset = 0;
    
    private Color color = new Color(109, 7, 26);

    /**
     * Creates new form PiratePawn
     */
    public PiratePawn() {
        initComponents();
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void moveTo(Point newLocation){
        System.out.println("boundary.graphics.personalizedComponents.PiratePawn.moveTo()" + (newLocation.x - getSize().width + offset) + " " + (newLocation.y - getSize().height + offset));
        setLocation(newLocation.x - getSize().width + offset, newLocation.y - getSize().height + offset);
        repaint();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(40, 40));
        setMinimumSize(new java.awt.Dimension(40, 40));
        setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

       
    public void activate(){
        this.activated = true;
    }
    
    public void desactivate(){
        this.activated = false;
    }

    public boolean isActivated() {
        return activated;
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(color);
        int[] xPoints = {getHeight()/2, getHeight(), getHeight()/2, 0};
        int[] yPoints = {0,getWidth()/2 , getWidth(), getWidth()/2};
        g.fillPolygon(xPoints, yPoints, 4);  
    }

    public void setOffset(int i) {
        this.offset = i;
    }
    
    public int getOffset(){
        return offset;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
