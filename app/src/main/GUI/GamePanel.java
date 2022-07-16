package GUI;

// Is used to create the GamePanel
import javax.swing.JPanel;

// Graphics components
import java.awt.*;
import java.awt.image.BufferedImage;

// Arraylist
import java.util.ArrayList;

// self created 
import tools.*;

// Objects 
import objects.Player;
import objects.worldObjects;
import objects_graphics.*;

// Gamestate
import Gamestate.Gamestate;

// Screens
import Screens.Deathscreen;
import Screens.Titlescreen;


public class GamePanel extends JPanel {

// ----Graphical components----//

    // Used integers for drawing the Menu background

    private int centerX = 1920/2;
    private int centerY = 1080/2;
    private int imageWidth = 1920;
    private int imageHeight = 1080;
    private int offsetX = imageWidth/2;
    private int offsetY = imageHeight/2;
    
    // GamePanel size
    private int screenWidth = 1920;
    private int screenHeight = 1080;

    // Importing images
    private DObjects dO = new DObjects();
    private BufferedImage playerImage, backgroundGP;

    // used for sprite animation
    private int currentImage = 1, counter = 0, counter2 = 90;

    // Screens
    Menu m = new Menu();
    Titlescreen t = new Titlescreen();
    Deathscreen d = new Deathscreen();
    
// ----Objects----//

    // Objects that should be drawn

    private ArrayList<worldObjects> sObjects;
    private Player actualPlayer;
    public int invincible;

// ----Tools----//

    // Keyhandler
    private MyKeyHandler kH;
    
    
    public GamePanel(MyKeyHandler kH, MyMouseHandler mH) {

        // Sets size of the GamePanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // Sets background color of the GamePanel to black
        this.setBackground(Color.black);

        // Puts the Panel in keyboard focus
        this.setFocusable(true);

        // adds keyHandler
        this.addKeyListener(kH);

        this.addMouseListener(mH);

        this.addMouseMotionListener(mH);
    }

    // Standard method to draw things on the JPanel
    public void paintComponent(Graphics g) {

        // Gamepanel is a subclass of the parent class JPanel that is why we must use super.
        super.paintComponent(g);

        // Changes Graphics g to Graphics2D (more functions)
        Graphics2D g2 = (Graphics2D)g;

        // Depeding on the Gamestate different things should be drawn
            switch(Gamestate.state) {
                case MENU:
                    m.draw(g2);
                    break;
                case PLAYING:
                    draw(g2); 
                    break;
                case DEATH:
                    d.draw(g2);
                    break;
                case TITLE:
                    t.draw(g2);
                    break;
                default:
                    break;
            }
 
        // Saves memory
        g2.dispose();
    }
    // Transfers Arraylist from the Gameloop, so they can be drawn in the paintComponent method
    public void gimmeThatArrayList(ArrayList<worldObjects> wO) {
        this.sObjects = wO;
    }

    // Function that draws all worldObjects

    public void draw(Graphics2D g2) {

        // Objects are stored inside the Arraylist, so the for-loop should go through the list so every object can be drawn
        for (int i = 0; i < sObjects.size(); i++) {

            int w = sObjects.get(i).width;
            int h = sObjects.get(i).height;
            int x = (int) sObjects.get(i).xpos;
            int y = 1080 - (int) sObjects.get(i).ypos - h;            // Up = up
            //int y = (int) sObjects.get(i).ypos;                         // upside down

            // Different objects depending on their type should be drawn differently - implementing switch statement
            switch (sObjects.get(i).getObjectType()){

            case "box":

                g2.setColor(new Color(60, 36, 22));

                g2.fillRect(x, y, w, h);

            break;

            case "player":

                if(actualPlayer.health > 0){

                    if (this.invincible == 0) {

                        // Setting default background while Playing
                        backgroundGP = dO.returnBackground();

                        // Draws background
                        g2.drawImage(backgroundGP, centerX - offsetX, centerY - offsetY, imageWidth, imageHeight, null);
                        
                        // Changes the player image so that depending on the movement a different sprite is drawn 
                        spriteAnimation();

                        // Draws Player
                        g2.drawImage(playerImage, x, y, w, h, null);

                    } else {

                        // Again Background stuff
                        backgroundGP = dO.returnBackground();

                        g2.drawImage(backgroundGP, centerX - offsetX, centerY - offsetY, imageWidth, imageHeight, null);

                        // When the player takes damage a animation for that is implemented
                        g2.setColor(Color.cyan);

                        g2.fillRect(x, y, w, h);

                    }

                }else{

                    // player is dead --> death animation

                    // Background
                    backgroundGP = dO.returnBackground();

                    g2.drawImage(backgroundGP, centerX - offsetX, centerY - offsetY, imageWidth, imageHeight, null);

                    // Death sprite
                    g2.drawImage(dO.returnImageDeath(), x, y, w, h, null);
                }

            break;

            case "trap":

                // Color is created with RGB values for the trap
                g2.setColor(new Color(94, 15, 13));
                g2.fillRect(x, y, w, h);

            break;

            case "trapPlus":

                
                g2.setColor(Color.green);
                g2.fillRect(x, y, w, h);

            break;
            
            case "generic":

            break;
            
            default:

                g2.setColor(Color.white);
                g2.fillRect(x, y, w, h);

            break;

            }
        } 

        // Counter which is used for switching walking sprites
        counter ++;

        // Counter which is used for switching idle sprites
        counter2 ++;
        
    }

    // Transfers Player
    public void getShit(int inv, Player P) {

        this.invincible = inv;
        this.actualPlayer = P;

    }

    // Transfers KeyHandler
    public void getSpace(MyKeyHandler kH) {

        this.kH = kH;

    }
    public void spriteAnimation() {

        // If-Statements asking which sprite should be drawn depending on the movement of the player

        // Idle
        if (actualPlayer.actMovR != true && actualPlayer.actMovL != true && actualPlayer.touchingGround == true) {

            if (counter2 > 90) {

                // dynamic switching between two animations, results into walking animation

                if (currentImage == 1) {

                    currentImage = 2;
                    counter2 = 0;
                    playerImage = dO.returnImageIdle1();

                } else if (currentImage == 2) {

                    currentImage = 1;
                    counter2 = 0;
                    playerImage = dO.returnImageIdle2();

                } 
            }
        }

        // Walking right
        if (actualPlayer.actMovR == true) {

            if (counter > 20) {
                
                // dynamic switching between two animations, results into walking animation

                if (currentImage == 1) {

                    currentImage = 2;
                    counter = 0;
                    playerImage = dO.returnImageRight1();

                } else if (currentImage == 2) {
                    currentImage = 1;
                    counter = 0;
                    playerImage = dO.returnImageRight2();
                } 
            
            } 
        }
        // Walking left
        if (actualPlayer.actMovL == true) {

            // dynamic switching between two animations, results into walking animation

            if (counter > 20) {

                if (currentImage == 1) {

                    currentImage = 2;
                    counter = 0;
                    playerImage = dO.returnImageLeft1();

        
                } else if (currentImage == 2) {

                    currentImage = 1;
                    counter = 0;
                    playerImage = dO.returnImageLeft2();

                } 
            } 
        }

        // Jump
        if (actualPlayer.touchingGround != true) {

            // Left jump
            if (actualPlayer.actMovL) {

                playerImage = dO.returnImageJumpL();

            // Right jump
            } else if (actualPlayer.actMovR) {
                
                playerImage = dO.returnImageJumpR();

            }

        } 

        // Jump while not moving
        if (actualPlayer.touchingGround != true && actualPlayer.actMovR != true && actualPlayer.actMovL != true){

            playerImage = dO.returnImageJumpL();

        }

        // Holding onto a Wall
        if (actualPlayer.spriteWall != false) {

            // Holding onto a Wall from left
            if (actualPlayer.actMovL) {

                playerImage = dO.returnImageGrabL();

            // Holding onto a Wall from right
            } else if (actualPlayer.actMovR) {

                playerImage = dO.returnImageGrabR();

            }  
        } 

        // Groundslam
        if (actualPlayer.isSlamming == true) {

            playerImage = dO.returnImageGroundslam();
            
        }
    }
}
