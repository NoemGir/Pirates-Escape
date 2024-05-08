/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics.personalizedComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;

/**
 * Panel personnalisé représentant un coeur de pirate
 *
 * @author Corentin JERE
 */
public class HeartPanel extends javax.swing.JPanel {
    /**
     * Creates new form PanelCoeur
     */
    public HeartPanel() {
        initComponents();
        try{
            imagePlein = ImageIO.read(new File(getClass().getResource("/coeurPlein.png").toURI()));
            imageVide = ImageIO.read(new File(getClass().getResource("/coeurVide.png").toURI()));
        }
        catch (URISyntaxException | IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void repaintHeart(boolean plein){
        this.plein = plein;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.plein){
            g.drawImage(imagePlein, 0, 0, 80, 80, this);
        }
        else{
            g.drawImage(imageVide, 0, 0, 80, 80, this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private BufferedImage imagePlein;
    private BufferedImage imageVide;
    private boolean plein = true;
}
