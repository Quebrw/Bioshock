package Screens;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import objects_graphics.DObjects;

import java.awt.Font;

import java.awt.Color;



public class Screen {

    public int centerX = 1920/2;
    public int centerY = 1080/2;

    public int stringX;
    public int stringY;

    public BufferedImage image;

    public int imageWidth = 500;
    public int imageHeight = 500;

    public int imageCenterX = centerX - imageWidth/2;
    public int imageCenterY = centerY - imageHeight/2;

    public DObjects dO2 = new DObjects();


    public int getStringWidth(String text, Graphics2D g2) {

        int stringX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return stringX;
    }
    public int getStringHeight(String text, Graphics2D g2) {

        int stringY = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight()/(2);

        return stringY;
    }
    
    public void drawString(Graphics2D g2, int size, String text, int heightY) {

        g2.setFont(new Font("Serif", Font.BOLD, size));

        int reallyCenteredX = centerX - getStringWidth(text, g2);

        g2.setColor(Color.white);

        g2.drawString(text, reallyCenteredX, heightY);
    }
}
