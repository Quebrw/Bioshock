package GUI;

//import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import tools.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


import objects.Player;
import objects.worldObjects;
import objects_graphics.*;
import test.GameLoop;


public class GamePanel extends JPanel {

    //private int Pxpos;
    //private int Pypos;
    //private int Pwidth;
    //private int Pheight;
    private ArrayList<worldObjects> sObjects;
    private MyKeyHandler kH;

    public int changeColor = 0;
    public int invincible;
    private Player actualPlayer;

    public int screenWidth = 1920;

    public int screenHeight = 1080;

    // used to draw the objects as Images

    private DObjects dO = new DObjects();
    private BufferedImage image;

    // used for sprite animation

    private int currentImage = 1, counter = 13;
    private MyKeyHandler kh;
    private boolean menuClose = false;

    //MyKeyHandler kH = new MyKeyHandler();

    Menu m = new Menu();
    
    //Gamestates

    public int gameState;
    public int gameStatePlaying = 1;
    public int gameStateMenu = 2;

    public GamePanel(MyKeyHandler kH) {

        // size of the GamePanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // sets background color of the GamePanel to black
        this.setBackground(Color.black);

        //Puts the Panel in keyboard focus
        this.setFocusable(true);

        // adds keyHandler
        this.addKeyListener(kH);

        gameState = gameStatePlaying;
    }

    // Outdated ? 
    // public void uGamePanel(int x, int y, int w, int h) {
    //     this.Pxpos = x;
    //     this.Pypos = y;
    //     this.Pheight = h;
    //     this.Pwidth = w;

    // }

    
    // standard method to draw things on the JPanel
    public void paintComponent(Graphics g) {

        // Gamepanel is a subclass of the parent class JPanel that is why we must use super.
        super.paintComponent(g);

        // changes Graphics g to Graphics2D (more functions)
        Graphics2D g2 = (Graphics2D)g;

            if(gameState == gameStatePlaying) {

                draw(g2); 

            }

            else if (gameState == gameStateMenu) {

                m.draw(g2);

            }

        // saves memory
        g2.dispose();
    }
    
    public void gimmeThatArrayList(ArrayList<worldObjects> wO) {
        this.sObjects = wO;
    }

    // function that draws all worldObjects

    public void draw(Graphics2D g2) {

        for (int i = 0; i < sObjects.size(); i++) {

            int w = sObjects.get(i).width;
            int h = sObjects.get(i).height;
            int x = (int) sObjects.get(i).xpos;
            int y = 1080 - (int) sObjects.get(i).ypos - h;            // Up = up
            //int y = (int) sObjects.get(i).ypos;                         // upside down

            switch (sObjects.get(i).getObjectType()){

            case "box":
                g2.setColor(Color.pink);

                g2.drawRect(x, y, w, h);
            break;

            case "player":
                if(actualPlayer.health > 0){
                    if (this.invincible == 0) {

                        // following if-sentences decide which image should be drawn, based on the movement of the player

                        // sprites which are drawn as the player moves to the right
                        
                        spriteAnimation();

                        // draw function

                        g2.drawImage(image, x, y, w, h, null);


                    } else {

                        g2.setColor(Color.cyan);

                        g2.drawRect(x, y, w, h);

                        changeColor = 0;
                    }

                }else{

                    // player is dead --> death animation

                    g2.drawImage(dO.returnImageDeath(), x, y, w, h, null);
                }
            break;

            case "trap":
                g2.setColor(Color.red);
                g2.drawRect(x, y, w, h);
            break;

            case "trapPlus":
                g2.setColor(Color.green);
                g2.drawRect(x, y, w, h);

            break;
            
            case "generic":

            break;
            
            default:
                g2.setColor(Color.white);
                g2.fillRect(x, y, w, h);
            break;
            }
        } 

        // counter is used to switch between sprites. This method is updated 60 times per second resulting in 5 changes per second if the player moves
        counter ++;
        
    }
    
    public void getShit(int inv, Player P) {
        this.invincible = inv;
        this.actualPlayer = P;
    }
    public void getSpace(MyKeyHandler kH) {
        this.kH = kH;
    }
    public void spriteAnimation() {

        if (actualPlayer.actMovR != true && actualPlayer.actMovL != true && actualPlayer.touchingGround == true) {

            if (counter > 120) {

                if (currentImage == 1) {
                    currentImage = 2;
                    counter = 0;
                    image = dO.returnImageIdle1();

                } else if (currentImage == 2) {
                    currentImage = 1;
                    counter = 0;
                    image = dO.returnImageIdle2();
                } 
            }
        }

        if (actualPlayer.actMovR == true) {
            if (counter > 25) {
                
                if (currentImage == 1) {
                    currentImage = 2;
                    counter = 0;
                    image = dO.returnImageRight1();
        // dynamic switching between two animations, results into walking animation
                } else if (currentImage == 2) {
                    currentImage = 1;
                    counter = 0;
                    image = dO.returnImageRight2();
                } 
            
            } 
        }
        // sprites which are drawn as the player moves to the left
        if (actualPlayer.actMovL == true) {
            if (counter > 25) {
                if (currentImage == 1) {
                    currentImage = 2;
                    counter = 0;
                    image = dO.returnImageLeft1();
        // dynamic switching between two animations, results into walking animation
                } else if (currentImage == 2) {
                    currentImage = 1;
                    counter = 0;
                    image = dO.returnImageLeft2();
                } 
            } 
        }

        // jump animation
        if (actualPlayer.touchingGround != true) {

            if (actualPlayer.actMovL) {

                image = dO.returnImageJumpL();

            } else if (actualPlayer.actMovR) {
                
                image = dO.returnImageJumpR();

            }
        }

        // insert wall climbing sprite here
        if (actualPlayer.spriteWall != false) {

            if (actualPlayer.actMovL) {

                image = dO.returnImageGrabL();
            } else if (actualPlayer.actMovR) {

                image = dO.returnImageGrabR();
            }
            
        } 
        if (actualPlayer.isSlamming == true) {

            image = dO.returnImageGroundslam();
        }


    }
}
