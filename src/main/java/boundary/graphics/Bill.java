
package boundary.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author payrau
 */
public class Bill extends javax.swing.JPanel {
private BufferedImage image;
private Image scaledImage;

    /**
     * Creates new form ImagePanel
     */
    public Bill() {
        initComponents();
        loadImage();
  
}
    private void loadImage(){
        
    try{
           image=ImageIO.read(new File("C:\\Users\\payra\\Desktop\\imagepirate\\tete1.jpg"));
           scaledImage= image.getScaledInstance(108, 108, Image.SCALE_SMOOTH);
        }catch(IOException e){
            throw new RuntimeException("Impossible de charger l'image",e);
           }
           
        }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(scaledImage != null){
            g.drawImage(scaledImage,0,0,this);
        }
    }
    
    @Override
    public Dimension getPreferredSize(){
        if(scaledImage!=null){
            return new Dimension(scaledImage.getWidth(this),scaledImage.getHeight(this));
        }
        return super.getPreferredSize();
    }
    
     
    
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
