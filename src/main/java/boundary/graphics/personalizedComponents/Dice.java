package boundary.graphics.personalizedComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import boundary.graphics.Dialog;
import boundary.graphics.DiceRoll;

/**
 * Panel Personnalisé représentant un dé
 *
 * @author Robin MOUNIER
 */
public class Dice extends javax.swing.JPanel {

    private int joueur = 0;
    private int value = 1;
    private int idDice;
    
    private LinkedList<BufferedImage> listeImages = new LinkedList<>();

    private DiceRoll diceRoll;

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

    /**
     * Défini le joueur
     * @param joueur le numéro du joueur actuelle
     */
    public void setJoueur(int joueur) {
        this.joueur = joueur;
        repaint();
    }

    /**
     * affiche la valeur donnée sur le dé
     * 
     * @param value la valeur à afficher
     */
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
        g.drawImage(listeImages.get(value+7*joueur), 0, 0, 100, 100, this);

    }
    
    /**
     * Dice Lance le roulement du dé
     * 
     * @param v la valeur sur laquelle le dé va tomber
     */
    public void  rollDice(int v){
        diceRoll.startDiceRoll(v);
    }

    /**
     * Défini le dialog
     * 
     * @param dialog le dialog
     */
    public void setDialog(Dialog dialog) {
        diceRoll = new DiceRoll(dialog, this);
    }
    /**
     * Défini l'identifiant du dé
     * 
     * @param idDice identifiant
     */
    public void setIdDice(int idDice) {
        this.idDice = idDice;
    }
    
    /**
     * Récupère l'identifiant du dé
     * 
     * @return l'identifiant
     */
    public int getIdDice() {
        return idDice;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

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
