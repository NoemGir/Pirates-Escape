
package boundary.graphics.personalizedComponents;

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
    private Image color; 
    private Image grey; 
    private String imageName = "/jackSparrow";
    /**
     * Creates new form ImagePanel
     */
    public PirateFace() {
        initComponents();
        loadImage();
    }
    
    
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
    
    public void ChangeImage(){
        if(scaledImage.equals(color)){
            scaledImage=grey;
        }else {
            scaledImage=color;
        }
        repaint();
    }

    public void setPirateImage(String pathName) {
        this.imageName = pathName;
        loadImage();
        repaint();
    }

    public String getImageName() {
        return imageName;
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
