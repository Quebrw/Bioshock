package objects_graphics;

//----Graphical stuff----//
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class DObjects {

    // BufferdImages in which the drawn images are stored
    public BufferedImage right1, right2, left1, left2, jumpR, jumpL, death, groundslam, grabR, grabL, idle1, idle2, nothing, titlescreen, background, menu, buttonBackground, damage, enemy, enemy_right, victory, doubleJump;

    public DObjects() {

        // Loads images
        gimmeThatImage();

    }

    // Method to fetch the player images (movement etc.)
    public void gimmeThatImage() {

        try {

            idle1 = ImageIO.read(getClass().getResourceAsStream("Idle.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("Idle_Left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("Running_Right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("Running_Right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("Running_Left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("Running_Left_2.png"));
            death = ImageIO.read(getClass().getResourceAsStream("death.png"));
            jumpR = ImageIO.read(getClass().getResourceAsStream("Jump_Right.png"));
            jumpL = ImageIO.read(getClass().getResourceAsStream("Jump_Left.png"));
            groundslam = ImageIO.read(getClass().getResourceAsStream("Groundslam.png"));
            grabR = ImageIO.read(getClass().getResourceAsStream("Grab_Right.png"));
            grabL = ImageIO.read(getClass().getResourceAsStream("Grab_Left.png"));
            titlescreen = ImageIO.read(getClass().getResourceAsStream("Titlescreen.png"));
            background = ImageIO.read(getClass().getResourceAsStream("Background.png"));
            menu = ImageIO.read(getClass().getResourceAsStream("Menu_screen.png"));
            buttonBackground = ImageIO.read(getClass().getResourceAsStream("Button_map.png"));
            damage = ImageIO.read(getClass().getResourceAsStream("Damage.png"));
            enemy = ImageIO.read(getClass().getResourceAsStream("Enemy.png"));
            victory = ImageIO.read(getClass().getResourceAsStream("Victory.png"));
            doubleJump = ImageIO.read(getClass().getResourceAsStream("double_Jump.png"));
            enemy_right = ImageIO.read(getClass().getResourceAsStream("Enemy_Right.png"));
            
        } catch (IOException e) {

            e.getStackTrace();

        }
    } 
    // Methods which return the images, so they can be used in the draw method to draw the player, screens etc.
    
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

    public BufferedImage returnImageJumpR() {

        return jumpR;

    }

    public BufferedImage returnImageJumpL() {

        return jumpL;

    }

    public BufferedImage returnImageGroundslam() {

        return groundslam;

    }

    public BufferedImage returnImageGrabR() {

        return grabR;

    }

    public BufferedImage returnImageGrabL() {

        return grabL;

    }

    public BufferedImage returnImageIdle1() {

        return idle1;

    }

    public BufferedImage returnImageIdle2() {

        return idle2;

    }

    public BufferedImage returnBackground() {

        return background;

    }

    public BufferedImage returnTitlescreen() {

        return titlescreen;

    }

    public BufferedImage returnMenuScreen() {

        return menu;

    }
    
    public BufferedImage returnEnemy() {

        return enemy;

    }

    public BufferedImage returnDamage() {

        return damage;

    }

    public BufferedImage returnVictory() {

        return victory;

    }

    public BufferedImage returnButtonBackground() {

        return buttonBackground;

    }

    public BufferedImage returnDoubleJump() {

        return doubleJump;

    }

    public BufferedImage returnEnemyRight() {

        return enemy_right;

    }

}
