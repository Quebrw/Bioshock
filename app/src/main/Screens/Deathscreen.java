package Screens;

//----Graphical stuff----//

import java.awt.Graphics2D;

import java.awt.Color;

public class Deathscreen extends Screen{

    // Used for the timer in the Deathscreen
    private int counter;
    private String stringCounter;

    // Used as title
    private String death = "You Died";

    // Image size
    private int imageWidth = 500;
    private int imageHeight = 500;

    // Image position
    private int imageCenterX = centerX - imageWidth/2;
    private int imageCenterY = centerY - imageHeight/2;

    public Deathscreen() {

    }

    // Draw method
    public void draw(Graphics2D g2) {

        // Used for the timer in the Deathscreen
        if (counter < 60) {

            stringCounter = "Returning to Title in 4 ...";
            counter++;

        } else if (counter >= 60 && counter < 120) {

            stringCounter = "Returning to Title in 3 ...";
            counter++;

        } else if (counter >= 120 && counter < 180) {

            stringCounter = "Returning to Title in 2 ...";
            counter++;

        } else if (counter >= 180 && counter < 240) {

            stringCounter = "Returning to Title in 1 ...";
            counter++;

        } else if (counter >= 240) {

            counter = 0;
        }

        // Transfers image
        image = dO2.returnImageDeath();

        // Draws title
        drawString(g2, 80, death, 150, Color.red);

        // Title should appear in red
        g2.setColor(Color.red);

        // Draws image
        g2.drawImage(image, imageCenterX, imageCenterY, imageWidth, imageHeight, null);

        // Draws timer
        drawString(g2, 40, stringCounter, 900, Color.white);

    }
}
