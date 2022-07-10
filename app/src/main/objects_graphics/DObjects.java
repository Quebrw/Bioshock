package objects_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DObjects {

    public BufferedImage right1, right2, left1, left2, jump, death, nothing;

    public DObjects() {

        gimmeThatImage();

    }

    // Method to fetch the player images (movement etc.)
    public void gimmeThatImage() {

        try {

            right1 = ImageIO.read(getClass().getResourceAsStream("running2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("running 2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("running2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("running 2.png"));
            death = ImageIO.read(getClass().getResourceAsStream("death.png"));
            jump = ImageIO.read(getClass().getResourceAsStream("jump.png"));
            
        } catch (IOException e) {
            //TODO: handle exception

            e.getStackTrace();
        }
    // methods which return the movement images, so they can be used in the draw method to draw the player
    } 
    public BufferedImage returnImageRight1() {

        return right1;
    }  
    public BufferedImage returnImageRight2() {

        return right2;
    }
    public BufferedImage returnImageLeft1() {

        return left1;
    }
    public BufferedImage returnImageLeft2() {

        return left2;
    }
    public BufferedImage returnImageDeath() {
    
        return death;
    }
    public BufferedImage returnImageJump() {

        return jump;
    }
}
