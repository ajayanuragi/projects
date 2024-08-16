import org.imgscalr.Scalr;
import util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsciiArt {


    public static void main(String[] args) {
        String imageName = "cred.png";
        String imagePath = Constants.PATH + imageName;

        try {
            File input = new File(imagePath);
            BufferedImage clone = ImageIO.read(input);
            BufferedImage image = Scalr.resize(clone, Scalr.Method.ULTRA_QUALITY, 160);
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            double[][] brightness = getBrightness(image, imageWidth, imageHeight);
            char[][] brightnessToAscii = mapBrightnesToAscii(brightness, imageHeight, imageWidth);
            printOutput(brightnessToAscii);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private static void printOutput(char[][] brightnessToAscii) {
        for (char[] chars : brightnessToAscii) {
            for (char aChar : chars) {
                System.out.print((aChar));
            }
            System.out.println();
        }
    }


    private static char[][] mapBrightnesToAscii(double[][] brightness, int imageHeight, int imageWidth) {
        String chars = "`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
        char[][] result = new char[imageHeight][imageWidth];
        for (int i = 0; i < brightness.length; i++) {
            for (int j = 0; j < brightness[i].length; j++) {
                char c1 = chars.charAt((int) Math.ceil(((chars.length() - 1) * brightness[i][j] / 255)));
                result[i][j] = c1;
            }
        }

        return result;
    }

    public static double[][] getBrightness(BufferedImage sampleImage, int width, int height) {
        double[][] brightness = new double[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int pixel = sampleImage.getRGB(col, row);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                brightness[row][col] = ((red + green + blue) / 3.0);
            }
        }
        return brightness;
    }
}
