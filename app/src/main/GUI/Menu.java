package GUI;

import GUI.GamePanel;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Rectangle;

import java.awt.event.MouseEvent;

import tools.*;

public class Menu extends JFrame{

    public boolean changeStateToPLAYING = true;
    public boolean changeStateToMenu = false;

    private int BHeight = 100;
    private int BWidth = 250;

    private int centerScreenX = 1525/2;
    private int centerScreenY = 830/2;

    final String menu = "MENU";
    private String play = "PLAY";
    private String options = "OPTIONS";
    private String quit = "QUIT";
    private MyMouseHandler mH;

    private boolean buttonPressed;

    private int index;

    private Rectangle hitbox;

    public Menu() {

    }
    
    public void draw(Graphics2D g2) {

        titleString(g2);

        buttons(g2, 500, play);

        buttons(g2, 550, options);

        buttons(g2, 600, quit);

        // g2.fillRect(centerX, centerY, BWidth, BHeight);
    }
    public int getStringWidth(String text, Graphics2D g2) {

        int centerX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return centerX;
    }
    public int getStringHeight(String text, Graphics2D g2) {

        int centerY = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight()/(2);

        return centerY;
    }
    public void titleString(Graphics2D g2) {

        g2.setFont(new Font("Serif", Font.BOLD, 64));

        int reallyCenteredX = centerScreenX - getStringWidth(menu, g2);

        g2.setColor(Color.white);

        g2.drawString(menu, reallyCenteredX, 150);
    }

    public void buttons(Graphics2D g2, int y, String text) {

        g2.setFont(new Font("Serif", Font.BOLD, 38));

        int reallyCenteredX = centerScreenX - getStringWidth(text, g2);

        g2.setColor(Color.white);

        hitbox = new Rectangle(reallyCenteredX, y, getStringWidth(text, g2), getStringHeight(text, g2) ); 

        g2.drawString(text, reallyCenteredX, y);

    }
    public void update() {

        index = 0;

        if (buttonPressed) {

            index = 1;

        } 
    }

    public boolean isButtonPressed() {
        return buttonPressed;
    }

    public void setButtonPressed(boolean buttonPressed) {
        this.buttonPressed = buttonPressed;
    }
    public void applyGamestates() {

    }
    public void resetBools() {

        buttonPressed = false;
    }
    public void mousePressed (MouseEvent e) {


    }
    

}
