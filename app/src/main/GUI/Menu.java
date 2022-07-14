package GUI;

import GUI.GamePanel;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Menu extends JFrame{

    public boolean changeStateToPLAYING = true;
    public boolean changeStateToMenu = false;

    private int BHeight = 100;
    private int BWidth = 250;

    private int centerScreenX = 1525/2;
    private int centerScreenY = 830/2;

    final String menu = "MENU";

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

       titleString(g2);

        // g2.fillRect(centerX, centerY, BWidth, BHeight);
    }
    public int getCenterXString(String text, Graphics2D g2) {

        int centerX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return centerX;
    }
    public void titleString(Graphics2D g2) {

        g2.setFont(new Font("Serif", Font.BOLD, 64));

        int reallyCenteredX = centerScreenX - getCenterXString(menu, g2);

        g2.setColor(Color.white);

        g2.drawString(menu, reallyCenteredX, 150);


    }
}
