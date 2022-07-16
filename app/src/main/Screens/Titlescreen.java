package Screens;

import java.awt.Color;

import java.awt.Graphics2D;


public class Titlescreen extends Screen{

    private String titleString = "EPIC POGOMAN";

    private int centerX = 1920/2;
    private int centerY = 1080/2;
    private int imageWidth = 1920;
    private int imageHeight = 1080;
    private int offsetX = imageWidth/2;
    private int offsetY = imageHeight/2;

    public Titlescreen() {

    }

    public void draw(Graphics2D g2) {

        image = dO2.titlescreen;

        g2.drawImage(image, centerX - offsetX , centerY - offsetY, imageWidth, imageHeight, null);

        drawString(g2, 80, titleString, 150, Color.black);

        drawString(g2, 40, "To start press Enter", 900, Color.black);

    }
    
    
}
