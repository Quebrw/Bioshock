package objects_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import tools.MyKeyHandler;

public class DObjects {

    MyKeyHandler kh;

    public BufferedImage right1, right2, left1, left2, jump, nothing;

    public DObjects() {

        gimmeThatImage();

    }
    public void gimmeThatImage() {

        try {

            right1 = ImageIO.read(getClass().getResourceAsStream("boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("boy_left_2.png"));
            jump = ImageIO.read(getClass().getResourceAsStream("death.png"));
            
        } catch (IOException e) {
            //TODO: handle exception

            e.getStackTrace();
        }
        
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
    public BufferedImage returnImageJump() {
    
        return jump;
    }
}
