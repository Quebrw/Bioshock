package GUI;

//import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

import tools.*;

import objects.Player;


public class GamePanel extends JPanel {

    private int Pxpos;
    private int Pypos;
    private int Pwidth;
    private int Pheight;

    public int screenWidth = 1920;

    public int screenHeight = 1080;

    //MyKeyHandler kH = new MyKeyHandler();

    public GamePanel() {

        // size of the GamePanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // sets background color of the GamePanel to black
        this.setBackground(Color.black);

        //Puts the Panel in keyboard focus
        //this.setFocusable(true);

        // adds keyHandler
        //this.addKeyListener(kH);
    }

    public void uGamePanel(int x, int y, int w, int h) {
        this.Pxpos = x;
        this.Pypos = y;
        this.Pheight = h;
        this.Pwidth = w;

    }

    
    // standard method to draw things on the JPanel
    public void paintComponent(Graphics g) {

        // Gamepanel is a subclass of the parent class JPanel that is why we must use super.
        super.paintComponent(g);

        // changes Graphics g to Graphics2D (more functions)
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.blue);


        g2.fillRect(Pxpos,Pypos,Pwidth,Pheight);

        // saves memory
        g2.dispose();
    }
    
    
    
}
