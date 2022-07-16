package Screens;

import java.awt.Color;

import java.awt.Graphics2D;

public class Titlescreen extends Screen{

    // Title

    private String titleString = "EPIC POGOMAN";

    // Image size
    private int centerX = 1920/2;
    private int centerY = 1080/2;
    private int imageWidth = 1920;
    private int imageHeight = 1080;
    private int offsetX = imageWidth/2;
    private int offsetY = imageHeight/2;

    public Titlescreen() {

    }

    // Draw function
    public void draw(Graphics2D g2) {

        // transfersImage
        image = dO2.returnTitlescreen();

        // Draws Background
        g2.drawImage(image, centerX - offsetX , centerY - offsetY, imageWidth, imageHeight, null);

        // Draws title
        drawString(g2, 80, titleString, 150, Color.black);

        // Draws text
        drawString(g2, 40, "To start press Enter", 900, Color.black);

    }
    
    
}
