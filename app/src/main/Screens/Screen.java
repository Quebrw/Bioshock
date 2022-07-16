package Screens;

//----Graphical stuff----//

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import objects_graphics.DObjects;

import java.awt.Font;

import java.awt.Color;

// Class from which every "Screen" can inherit its functions and variables
public class Screen {

    // Graphics

    public int centerX = 1920/2;
    public int centerY = 1080/2;

    // For centering Text
    public int stringX;
    public int stringY;

    // For drawing images
    public DObjects dO2 = new DObjects();
    public BufferedImage image;

    // Centering String
    public int getStringWidth(String text, Graphics2D g2) {

        int stringX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return stringX;

    }

    // Centering String
    public int getStringHeight(String text, Graphics2D g2) {

        int stringY = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight()/(2);

        return stringY;
    }
    
    // Drawing text
    public void drawString(Graphics2D g2, int size, String text, int heightY, Color color) {

        // Font
        g2.setFont(new Font("Serif", Font.BOLD, size));

        // Centering
        int reallyCenteredX = centerX - getStringWidth(text, g2);

        // Color
        g2.setColor(color);

        // Drawing
        g2.drawString(text, reallyCenteredX, heightY);
    }
}
