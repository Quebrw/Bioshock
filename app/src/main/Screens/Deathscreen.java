package Screens;

import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.image.BufferedImage;

public class Deathscreen extends Screen{

    private int counter;

    private String death = "You ded hehe get fd nub";

    private String stringCounter;

    public Deathscreen() {


    }
    public void draw(Graphics2D g2) {

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

        image = dO2.returnImageDeath();

        drawString(g2, 80, death, 150);

        g2.setColor(Color.red);

        g2.drawImage(image, imageCenterX, imageCenterY, imageWidth, imageHeight, null);

        drawString(g2, 40, stringCounter, 900);

    }
    
}
