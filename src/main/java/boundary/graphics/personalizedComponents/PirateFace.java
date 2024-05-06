
package boundary.graphics.personalizedComponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;

/**
 *
 * @author Fabien
 */
public class PirateFace extends javax.swing.JPanel {
    
    private Image scaledImage; 
    private String imageName = "/jackSparrow.jpg";
    /**
     * Creates new form ImagePanel
     */
    public PirateFace() {
        initComponents();
        loadImage();
    }
    
    
    private void loadImage(){
        
        try{
           BufferedImage image = ImageIO.read(new File(getClass().getResource(imageName).toURI()));
           scaledImage = image.getScaledInstance(108, 108, Image.SCALE_SMOOTH);
        }catch(URISyntaxException | IOException e){
            throw new RuntimeException("Impossible de charger l'image",e);
        }   
    }
    
    public void colorImage(){
        //TODO
    }
    
    public void greyImage(){
        //TODO
    }

    public void setPirateImage(String pathName) {
        this.imageName = pathName;
        loadImage();
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(scaledImage != null){
            g.drawImage(scaledImage,0,0,120, 120, this);
        }
    }
    /*
    @Override
    public Dimension getPreferredSize(){
        if(scaledImage!=null){
            return new Dimension(scaledImage.getWidth(this),scaledImage.getHeight(this));
        }
        return super.getPreferredSize();
    }
    */
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
