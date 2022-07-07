package GUI;

//import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import tools.*;


import objects.Player;
import objects.worldObjects;


public class GamePanel extends JPanel {

    //private int Pxpos;
    //private int Pypos;
    //private int Pwidth;
    //private int Pheight;
    private ArrayList<worldObjects> sObjects;

    public int changeColor = 0;
    public int invincible;
    private Player actualPlayer;

    public int screenWidth = 1920;

    public int screenHeight = 1080;

    //MyKeyHandler kH = new MyKeyHandler();

    public GamePanel(MyKeyHandler kH) {

        // size of the GamePanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // sets background color of the GamePanel to black
        this.setBackground(Color.black);

        //Puts the Panel in keyboard focus
        this.setFocusable(true);

        // adds keyHandler
        this.addKeyListener(kH);
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

        draw(g2);

        // saves memory
        g2.dispose();
    }
    
    public void gimmeThatArrayList(ArrayList<worldObjects> wO) {
        this.sObjects = wO;
    }

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

                        g2.setColor(Color.green);

                        g2.drawRect(x, y, w, h);


                    } else {

                        g2.setColor(Color.cyan);

                        g2.drawRect(x, y, w, h);

                        changeColor = 0;
                    }

                }else{

                    g2.setColor(Color.white);

                    g2.drawRect(x,y,w,h);
                }
            break;

            case "trap":
                g2.setColor(Color.red);
                //g2.draw3DRect(x, y, w, h, false);
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

        
    }
    
    public void getShit(int inv, Player P) {
        this.invincible = inv;
        this.actualPlayer = P;
    }

}
