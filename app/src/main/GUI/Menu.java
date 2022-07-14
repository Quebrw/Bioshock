package GUI;

import GUI.GamePanel;

import java.awt.Graphics2D;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Menu extends JFrame{

    public boolean changeStateToPLAYING = true;
    public boolean changeStateToMenu = false;

    private int BHeight = 100;
    private int BWidth = 250;



    private int centerX = 1525/2 - BWidth/2;
    private int centerY = 830/2 - BHeight/2;

    JLabel label;

    public Menu() {

    }
    public void update() {


    }
    public boolean changeStatePlaying() {

        if (changeStateToMenu = true) {

            changeStateToMenu = false;
        }

        return changeStateToPLAYING;
    }
    public boolean changeStatePlaying2() {

        return changeStateToMenu = false;
    }
    public boolean changeStateMenu() {

        if (changeStateToPLAYING = true) {
            
            changeStateToPLAYING = false;
        }

        return changeStateToMenu;
    }
    public boolean changeStateMenu2() {

        return changeStateToPLAYING = false;
    }
    public void draw(Graphics2D g2) {

        g2.setColor(Color.green);

        g2.fillRect(centerX, centerY, BWidth, BHeight);

        

        


    }
    
    
}
