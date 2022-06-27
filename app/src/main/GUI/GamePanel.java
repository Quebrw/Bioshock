package GUI;

//import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

import tools.*;

import objects.Player;


public class GamePanel extends JPanel {

    int playerX = 100;
    int playerY = 100;

    public int screenWidth = 1920;

    public int screenHeight = 1080;

    MyKeyHandler kH = new MyKeyHandler();

    public GamePanel() {

        // size of the GamePanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // sets background color of the GamePanel to black
        this.setBackground(Color.black);

        //Puts the Panel in keyboard focus
        this.setFocusable(true);

        // adds keyHandler
        this.addKeyListener(kH);
    }

    // standard method to draw things on the JPanel
    public void paintComponent(Graphics g) {

        // Gamepanel is a subclass of the parent class JPanel that is why we must use super.
        super.paintComponent(g);

        // changes Graphics g to Graphics2D (more functions)
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, 100, 100);

        // saves memory
        g2.dispose();
    }
    
    
    
}
