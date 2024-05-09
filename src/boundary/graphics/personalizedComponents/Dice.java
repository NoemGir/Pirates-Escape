/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics.personalizedComponents;

import boundary.graphics.Dialog;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Robin
 */
public class Dice extends javax.swing.JPanel {
    
    private int Joueur = 0;
    private int value = 1;
    private LinkedList<BufferedImage> listeImages = new LinkedList<>();

    private DiceTimeWorker diceTimeWorker;

    
    /**
     * Creates new form Dice
     */
    public Dice() {
        initComponents();
        try{
            listeImages.add(ImageIO.read(new File(getClass().getResource("/1.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/2.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/3.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/4.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/5.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/6.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/7.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/1b.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/2b.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/3b.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/4b.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/5b.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/6b.png").toURI())));
            listeImages.add(ImageIO.read(new File(getClass().getResource("/7b.png").toURI())));

    }catch(Exception e){
        System.out.println(e);
    }
        repaint();
    }

    public void setJoueur(int Joueur) {
        this.Joueur = Joueur;
    }

    public void display(int value){
        this.value = value;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.value<0){
            this.value *= (-1);
        }
        g.drawImage(listeImages.get(value+7*Joueur), 0, 0, 100, 100, this);

    }

    public void  setDiceValue(int v){
        DiceTimeWorker timer = new DiceTimeWorker(v);
        diceTimeWorker.setValue(v);
        diceTimeWorker.execute();
    }    
    
    public DiceTimeWorker getDiceTimeWorker(){
        return this.diceTimeWorker;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1542, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
