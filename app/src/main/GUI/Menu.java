package GUI;

import GUI.GamePanel;
import Gamestate.Gamestate;
import test.GameLoop;

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

    public static int userInput;

    final String menu = "MENU";

    GamePanel gP;

    ArrayList<MenuButtons> menuButtons = new ArrayList<MenuButtons>();

        MenuButtons b_play = new MenuButtons("PLAY", 500);
        MenuButtons b_options = new MenuButtons("OPTIONS", 550);
        MenuButtons b_quit = new MenuButtons("QUIT", 600);
    

    int y = 300;

    

    public Menu() {

        addMenuButtons();

    }
    
    public void draw(Graphics2D g2) {

        titleString(g2);

        for (int i = 0; i < menuButtons.size(); i++) {

            menuButtons.get(i).draw(g2, menuButtons.get(i).y, menuButtons.get(i).text);

        }

        drawCursor(g2);

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
    public void addMenuButtons() {

        menuButtons.add(b_play);
        menuButtons.add(b_options);
        menuButtons.add(b_quit);
    }
    public void drawCursor(Graphics2D g2) {

        if (userInput == 0) {

            g2.drawString(">", 1920/2 - menuButtons.get(0).getStringWidth("Play", g2) - 90, menuButtons.get(0).y);

        } else if (userInput == 1) {

            g2.drawString(">", 1920/2 - menuButtons.get(1).getStringWidth("Options", g2) - 90, menuButtons.get(1).y);

        } else if (userInput == 2) {

            g2.drawString(">", 1920/2 - menuButtons.get(2).getStringWidth("Quit", g2) - 90, menuButtons.get(2).y);

        }
    } 
}
