package GUI;

//----Graphical components----//
import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.Font;

public class MenuButtons {

    //----Graphical Stuff----//
    
    private int centerScreenX = 1920/2;

    public String text;

    public int y;

    public MenuButtons(String text, int y) {

        this.text = text;
        this.y = y;

    }

    // Draw function to draw the buttons
    public void draw(Graphics2D g2, int y, String text) {

        // Font
        g2.setFont(new Font("Serif", Font.BOLD, 38));

        // Centering text
        int reallyCenteredX = centerScreenX - getStringWidth(text, g2);

        // Text should appear black
        g2.setColor(Color.black);

        // Draws "buttons"
        g2.drawString(text, reallyCenteredX, y);

    }

    // Function that gets the width of a text and returns it
    public int getStringWidth(String text, Graphics2D g2) {

        int centerX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return centerX;

    }

    // Function that gets the height of a text and returns it
    public int getStringHeight(String text, Graphics2D g2) {

        int centerY = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight()/(2);

        return centerY;

    }
}
