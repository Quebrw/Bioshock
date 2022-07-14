package GUI;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import tools.*;

public class MenuButtons {

    private Rectangle hitbox;
    
    private int centerScreenX = 1525/2;
    private int centerScreenY = 830/2;

    public String text;
    public int y;

    private String play = "PLAY";
    private String options = "OPTIONS";
    private String quit = "QUIT";

    


    public MenuButtons(String text, int y) {

        this.text = text;
        this.y = y;

    }

    public void draw(Graphics2D g2, int y, String text) {

        g2.setFont(new Font("Serif", Font.BOLD, 38));

        int reallyCenteredX = centerScreenX - getStringWidth(text, g2);

        g2.setColor(Color.white);

        hitbox = new Rectangle(reallyCenteredX, y, getStringWidth(text, g2), getStringHeight(text, g2) ); 

        g2.drawString(text, reallyCenteredX, y);

    }
    public int getStringWidth(String text, Graphics2D g2) {

        int centerX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return centerX;
    }
    public int getStringHeight(String text, Graphics2D g2) {

        int centerY = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight()/(2);

        return centerY;
    }
    
}