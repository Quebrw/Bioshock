package objects_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import tools.MyKeyHandler;

public class DObjects {

    MyKeyHandler kh;

    public BufferedImage right1, right2, nothing;

    public DObjects() {

        gimmeThatImage();

    }
    public void gimmeThatImage() {

        try {

            right1 = ImageIO.read(getClass().getResourceAsStream("boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("boy_right_2.png"));
            
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
}
