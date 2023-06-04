package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {


    public static BufferedImage loadImage(File imageFile) {
        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    public static void paint(BufferedImage image, Color color, int threshold) {
        for (int j = 0; j < image.getHeight(); j++) {
            for (int i = 0; i < image.getWidth(); i++) {
                Color c = new Color(image.getRGB(j, i));
                if (c.getRed() >= threshold && c.getGreen() >= threshold && c.getBlue() >= threshold) {
                    image.setRGB(j, i, color.getRGB());
                }
            }
        }
    }

    public static void paint(BufferedImage image, Color oldColor, Color newColor) {
        int oldColorRgb = oldColor.getRGB(), newColorRgb = newColor.getRGB();
        for (int j = 0; j < image.getHeight(); j++) {
            for (int i = 0; i < image.getWidth(); i++) {
                if (image.getRGB(j, i) == oldColorRgb)
                    image.setRGB(j, i, newColorRgb);
            }
        }
    }

}
