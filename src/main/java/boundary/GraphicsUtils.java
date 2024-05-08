/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import boundary.graphics.personalizedComponents.PiratePawn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Cette classe regroupe des méthodes pouvant être utiles aux classes présentes dans le boundary 
 * 
 * @author Fabien
 * @author Noémie GIREAUD
 * 
 */
public class GraphicsUtils {

    /**
    * Convertis une image colorée en une image noir et blanc
    * 
    * @author Fabien
    * 
    * @param inputFilePath le chemin de l'image coloré
    * @param outputFilePath le chemin de l'image en noir et blanc
    */
    public static void convertToBlackAndWhite(String inputFilePath, String outputFilePath) {
        try{
            BufferedImage inputImage=ImageIO.read(new File(inputFilePath));
            int width = inputImage.getWidth();
            int height=inputImage.getHeight();
            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            
            for(int y = 0;y<height;y++){
                for(int x=0;x<width;x++){
                    Color color = new Color(inputImage.getRGB(x, y));
                    int average = (color.getRed()+color.getGreen()+color.getBlue())/3;
                    Color gray = new Color(average,average,average);
                    outputImage.setRGB(x, y, gray.getRGB());
                }
            }
            ImageIO.write(outputImage,"jpg",new File(outputFilePath));
            System.out.println("Conversion terminée\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
    * Calcule les coordonnées du milieu d'une case du plateau
    * 
    * @author Noémie GIREAUD
    * 
    * @param box Une case du plateau
    * @return un Point possèdant les coordonnées du milieu de la case donnée
    */
    public static Point computeLocationPawnInCase(Component box){
        int dest_x = box.getLocation().x + box.getSize().width/2;
        int dest_y = box.getLocation().y + box.getSize().height/2;
        return new Point(dest_x, dest_y);
    }
    
    /**
    * Calcule les coordonnées pour placer le milieu du pion dans la localisation voulue
    * 
    * @author Noémie GIREAUD
    * 
    * @param location une localisation
    * @param pawn le pion à rediriger
    * @return la localisation que le pion doit avoir pour que sont milieu soit à la localisation voulue
    */
    public static Point computeLocationInsidePawn(Point location, PiratePawn pawn){
        //getOffset() -> ajoute un offset pour que les pions ne se surperposent pas entièrement
        int dest_x = location.x - pawn.getSize().width/2 + pawn.getOffset();
        int dest_y = location.y - pawn.getSize().height/2 + pawn.getOffset();
        return new Point(dest_x, dest_y);
    }
    
    /**
    * Récupère un Icon depuis une image
    * 
    * @author Noémie GIREAUD
    * 
    * @param path le nom de l'image 
    * @return un Icon représentant l'image, de taille 70 x 70
    */
    public static Icon getIcon(String path){       
        URL imageURL = new GraphicsUtils().getClass().getResource(path);
        ImageIcon imageIcon = new ImageIcon(imageURL);
        Image image = imageIcon.getImage(); // Transform it
        Image scaledImage = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage); 

    }
}
