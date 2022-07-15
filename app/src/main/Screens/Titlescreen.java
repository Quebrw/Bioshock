package Screens;

import java.awt.Color;

import java.awt.Graphics2D;




import objects_graphics.*;

public class Titlescreen extends Screen{

    private DObjects dO;

    private String titleString = "EPIC POGOMAN";

    public Titlescreen() {

    }

    public void draw(Graphics2D g2) {

        image = dO2.returnImageGroundslam();

        drawString(g2, 80, titleString, 150);

        g2.setColor(Color.white);

        g2.drawImage(image, imageCenterX, imageCenterY, imageWidth, imageHeight, null);

        drawString(g2, 40, "To start press Enter", 900);

    }
    
    
}
