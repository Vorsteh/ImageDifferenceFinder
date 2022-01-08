import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Difference {
    public static void main(String[] args) {
        System.out.println("Starting: ");
        long start = System.currentTimeMillis();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/me.jpg"));

        } catch (IOException e) {
            System.out.println("Couldn't find image");
        }
        BufferedImage test = image;
        Graphics2D t = (Graphics2D) test.getGraphics();

        int barrier = 0;
        barrier = (image.getWidth()/2) + 28;

        int pixel1, red1, green1, blue1;
        int pixel2, red2, green2, blue2;
        int pixels = 0;


        for(int i = 0; i < image.getHeight(); i++){
            for(int j = 0; j < image.getWidth() - (barrier); j++){

                pixel1 = image.getRGB(j, i);
                red1 = (pixel1 >> 16) & 0xff;
                green1 = (pixel1 >> 8) & 0xff;
                blue1 = (pixel1) & 0xff;

                pixel2 = image.getRGB(j + (barrier), i);
                red2 = (pixel2 >> 16) & 0xff;
                green2 = (pixel2 >> 8) & 0xff;
                blue2 = (pixel2) & 0xff;

                if(red1 <= red2 && red1 + 35 >= red2){
                    t.drawRect(i, j,1, 1);
                } else if(red2 <= red1 && red2 + 35 >= red1){
                    t.drawRect(i, j, 1, 1);
                }

                if(green1 <= green2 && green1 + 35 >= green2){
                    t.drawRect(i, j,1, 1);
                } else if(green2 <= green1 && green2 + 35 >= green1){
                    t.drawRect(i, j, 1, 1);
                }

                if(blue1 <= blue2 && blue1 + 35 >= blue2){
                    t.drawRect(i, j,1, 1);
                } else if(blue2 <= blue1 && blue2 + 35 >= blue1){
                    t.drawRect(i, j, 1, 1);
                }
                System.out.println("Pixel " + i + " " + j + " done");
                pixels++;
            }
        }

        try {
            File output = new File("image-output.jpg");
            ImageIO.write(test, "jpg", output);
        } catch (Exception e){
            System.out.println("Could write file");
        }
        long stop = System.currentTimeMillis();

        System.out.println(pixels + " pixels finished in: " + (float) (stop - start) / 1000 + "s");
    }
}
