
package boundary.graphics.personalizedComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;

/**
 * Panel Personnalisé représentant le visage du pirate
 *
 * @author Fabien
 */
public class PirateFace extends javax.swing.JPanel {

    private Image scaledImage;
    private Image color;
    private Image grey;
    private String imageName = "/jackSparrow";
    private Color liner = Color.red;
    
    /**
     * Creates new form ImagePanel
     */
    public PirateFace() {
        initComponents();
        loadImage();
    }

    /**
     * Charge les images colorées et noir et blanc 
     */
    private void loadImage(){
        try{
           BufferedImage image = ImageIO.read(new File(getClass().getResource(imageName+".jpg").toURI()));
           scaledImage = image.getScaledInstance(108, 108, Image.SCALE_SMOOTH);
           color = scaledImage;
           grey = ImageIO.read(new File(getClass().getResource(imageName+"-modified.jpg").toURI()));
        }catch(URISyntaxException | IOException e){
            throw new RuntimeException("Impossible de charger l'image",e);
        }
    }

    /**
     * change la couleur de l'image
     */
    public void changeImageColor(){
        if(scaledImage.equals(color)){
            scaledImage=grey;
        }else {
            scaledImage=color;
        }
        repaint();
    }

    /**
     * Défini l'image de la photo du pirate
     * @param pathName 
     */
    public void setPirateImage(String pathName) {
        this.imageName = pathName;
        loadImage();
        repaint();
    }

    /**
     * Récupère le nom de l'image
     * @return 
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 
     * Défini la couleur de contour de l'image
     * 
     * @author Robin MOUNIE
     * 
     * @param liner la couleur de contour
     */
    public void setLiner(Color liner) {
        this.liner = liner;
    }
    
    /**
     * 
     * @author Fabien
     * @author Robin
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(liner);
        g.fillRect(0, 0, 120, 120);
        if(scaledImage != null){
            g.drawImage(scaledImage,10,10,100, 100, this);

            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


}
