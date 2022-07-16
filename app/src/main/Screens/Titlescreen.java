package Screens;

import java.awt.Color;

import java.awt.Graphics2D;


public class Titlescreen extends Screen{

    private String titleString = "EPIC POGOMAN";

    public Titlescreen() {

    }

    public void draw(Graphics2D g2) {

        image = dO2.returnImageGroundslam();

        drawString(g2, 80, titleString, 150, Color.white);

        g2.setColor(Color.white);

        g2.drawImage(image, imageCenterX, imageCenterY, imageWidth, imageHeight, null);

        drawString(g2, 40, "To start press Enter", 900, Color.white);

    }
    
    
}
