/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics.personalizedComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Panel personnalisé correspondant à une case du plateau
 *
 * @author Noémie GIREAUD
 */
public class CasePanel extends javax.swing.JPanel {

    /**
     * Creates new form CasePanel
     */
    private BufferedImage boxImage;
    public CasePanel() {
        initComponents();
    }

    public void setBoxImage(String boxImage) {
        try{
            this.boxImage =ImageIO.read(new File(getClass().getResource(boxImage).toURI()));
        }catch(Exception e){
            //System.out.println("boundary.graphics.personalizedComponents.CasePanel.setBoxImage() : Error loading image box");
        }
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

                g.drawImage(this.boxImage, 0, 0, getWidth(), getHeight(), this);

    }
    
    
    /**
    * Indique le texte à écrire sur la case 
    * 
    * @param texte Le texte à écrire
    */
    public void setText(String texte){
        jLabel1.setText(texte);
    }
    
    /**
    * Ajoute une bordure verte sur la case
    */
    public void putGreenBorder(){
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));
    }
    
    /**
    * Remet une bordeur classique à la case
    */
    public void putBlackBorder(){
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
