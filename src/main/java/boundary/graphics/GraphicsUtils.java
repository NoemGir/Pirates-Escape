/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author payrau
 */
public class GraphicsUtils {

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
    
}
