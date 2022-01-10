import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Driver4 {
    public static void main(String[] args) {
        //Starts timer
        long start = System.currentTimeMillis();

        //Loads image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/me.jpg"));
        }catch (Exception e){
            System.out.println("Kunde inte hitta bild");
        }
        BufferedImage test = image;
        Graphics2D t = (Graphics2D) test.getGraphics();

        //Calculates border in middle of picture(Needs changing based on image)
        int border = 0;
        border = image.getWidth() / 2;
        border += 28;

        //Pixels and RBG colors
        int pixel1, red1, green1, blue1;
        int pixel2, red2, green2, blue2;

        //Amount of pixels in the image
        int pixels = 0;

        //Color of background
        t.setColor(Color.white);
        //White (255, 255, 255)
        //Black (0, 0, 0)
        //Blue (0, 0, 255)
        //Red (255, 0, 0)


        //Loops through the whole image
        for(int i = 0; i < image.getHeight(); i++){
            for(int j = 0; j < image.getWidth() - (border); j++){
                //Gets pixel1's RGB values
                pixel1 = image.getRGB(j, i);
                red1 = (pixel1 >> 16) & 0xff;
                green1 = (pixel1 >> 8) & 0xff;
                blue1 = (pixel1) & 0xff;

                //Gets pixel2's RGB values
                pixel2 = image.getRGB(j + (border), i);
                red2 = (pixel2 >> 16) & 0xff;
                green2 = (pixel2 >> 8) & 0xff;
                blue2 = (pixel2) & 0xff;


                //Looks through the RBG values
                if(red1 <= red2 && red1 + 35 >= red2){
                    t.fillRect(j, i, 1, 1);
                }else if(red1 >= red2 && red2 + 35 >= red1){
                    t.fillRect(j, i, 1, 1);
                }

                if(green1 <= green2 && green1 + 35 >= green2){
                    t.fillRect(j, i, 1, 1);
                }else if(green1 >= green2 && green2 + 35 >= green1){
                    t.fillRect(j, i, 1, 1);
                }

                if(blue1 <= blue2 && blue1 + 35 >= blue2){
                    t.fillRect(j, i, 1, 1);
                }else if(blue1 >= blue2 && blue2 + 35 >= blue1){
                    t.fillRect(j, i, 1, 1);
                }

                //Adds to the amount of pixels done
                pixels++;
            }
        }

        //Creates new file for new image
        try {
            File output = new File("image-output1.jpg");
            ImageIO.write(test, "jpg", output);
        }catch (IOException e){
            System.out.println("Couldn't write to file");
        }
        //Stops timer
        long stop = System.currentTimeMillis();
        //Calculates the timer in Seconds instead of ms
        float timeInSeconds = (float) (stop - start) / 1000;
        //Prints out amount of time for program to finish
        System.out.println("The program took " + timeInSeconds + " to finish checking " + pixels + " pixels.");
    }
}
