package objects_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DObjects {

    public BufferedImage right;

    public DObjects() {

        gimmeThatImage();

    }
    public void gimmeThatImage() {

        try {

            right = ImageIO.read(getClass().getResourceAsStream("boy_right_2.png"));
            
        } catch (IOException e) {
            //TODO: handle exception

            e.getStackTrace();
        }
        
    }
    public BufferedImage returnImage() {

        return right;
    }

    
}
