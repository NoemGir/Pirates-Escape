/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics.personalizedComponents;

import boundary.GraphicsUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Panel personnalisé représentant un pion
 *
 * @author Noémie GIREAUD
 */
public class PiratePawn extends javax.swing.JPanel {
    
    private int offset = 0;
    private Color color = Color.red;
    private Component box;
    
    /**
     * Creates new form PiratePawn
     */
    public PiratePawn() {
        initComponents();
    }
    
    /**
     * Définie la couleur du pion
     * 
     * @param color future couleur du pion
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Défine la case du pion
     * 
     * @param box La case sur laquelle est placée le pion
     */
    public void setBox(Component box) {
        this.box = box;
    }
    
    /**
     * Défine la localisation du pion
     * 
     * @param newLocation Lles coordonnées de la nouvelle localisation
     */
    public void moveTo(Point newLocation){
        setLocation(GraphicsUtils.computeLocationInsidePawn(newLocation, this));
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

    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(color);
        int[] xPoints = {getHeight()/2, getHeight(), getHeight()/2, 0};
        int[] yPoints = {0,getWidth()/2 , getWidth(), getWidth()/2};
        g.fillPolygon(xPoints, yPoints, 4);  
    }

    /**
     * Définie l'offset du pion
     * @param i le niveau de offset
     */
    public void setOffset(int i) {
        this.offset = i;
    }
    
    /**
     * Récupère le offset du pion
     * 
     * @return le niveau de offset du pion
     */
    public int getOffset(){
        return offset;
    }
    
    
    /**
     * Fait en sorte que le pion se replace correctement au centre de sa case
     * Methode appellée lorsque un repaint du plateau est activé, le plus souvent si la fenêtre change de taille
     * 
     */
    void resetLocation() {
        if(box != null){
            Point location = GraphicsUtils.computeLocationPawnInCase(box);
            moveTo(location);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
