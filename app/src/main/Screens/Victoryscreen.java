package Screens;

//----Graphical Stuff----//

import java.awt.Color;

import java.awt.Graphics2D;

public class Victoryscreen extends Screen{

    // Image size
    private int centerX = 1920/2;
    private int centerY = 1080/2;
    private int imageWidth = 1920;
    private int imageHeight = 1080;
    private int offsetX = imageWidth/2;
    private int offsetY = imageHeight/2;

    private String victory = "Victory";

    public void draw(Graphics2D g2) {

        // transfersImage
        image = dO2.returnVictory();

        // Draws Background
        g2.drawImage(image, centerX - offsetX , centerY - offsetY, imageWidth, imageHeight, null);

        // Draws title
        drawString(g2, 80, victory, 150, Color.black);

        // Draws text
        drawString(g2, 40, "Acquired Bachelor in Computer Science", 900, Color.black);

    }
    
    
    
}
