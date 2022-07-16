package GUI;

import GUI.GamePanel;
import Gamestate.Gamestate;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import tools.*;



public class Menu{

    public boolean changeStateToPLAYING = true;
    public boolean changeStateToMenu = false;

    private int BHeight = 100;
    private int BWidth = 250;

    private int centerScreenX = 1920/2;
    private int centerScreenY = 1080/2;

    final String menu = "MENU";

    private MyMouseHandler mH;

    GamePanel gP;

    ArrayList<MenuButtons> menuButtons = new ArrayList<MenuButtons>();

        MenuButtons b_play = new MenuButtons("PLAY", 500, Gamestate.PLAYING);
        MenuButtons b_options = new MenuButtons("OPTIONS", 550, Gamestate.OPTIONS);
        MenuButtons b_quit = new MenuButtons("QUIT", 600, Gamestate.QUIT);
    

    int y = 300;

    

    public Menu() {

        addMenuButtons();

    }
    
    public void draw(Graphics2D g2) {

        titleString(g2);

        for (int i = 0; i < menuButtons.size(); i++) {

            menuButtons.get(i).draw(g2, menuButtons.get(i).y, menuButtons.get(i).text);

        }

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

   

    
    public void applyGamestates() {

    }
   
    public void mousePressed (MouseEvent e) {
        for (MenuButtons mb : menuButtons) {
            if (mb.isIn(e, mb)) {

                mb.setButtonPressed(true);
                break;
            }
        }


    }
    public void mouseReleased(MouseEvent e) {
        for (MenuButtons mb : menuButtons) {
            if (mb.isIn(e, mb)) {
                if(mb.isButtonPressed())
                    mb.applyGamestate();
                    break;

            }
        resetButtons();
    }
}
    private void resetButtons() {
        for (MenuButtons mb : menuButtons) 

            mb.resetBools(); 

    }

    public void addMenuButtons() {

        menuButtons.add(b_play);
        menuButtons.add(b_options);
        menuButtons.add(b_quit);
    }
    
}
