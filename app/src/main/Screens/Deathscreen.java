package Screens;

import java.awt.Graphics2D;

import java.awt.Color;

public class Deathscreen extends Screen{

    private String death = "You ded hehe get fd nub";

    

    public Deathscreen() {


    }
    public void draw(Graphics2D g2) {

        image = dO2.returnImageDeath();

        drawString(g2, 80, death, 150);

        g2.setColor(Color.white);

        g2.drawImage(image, imageCenterX, imageCenterY, imageWidth, imageHeight, null);

        drawString(g2, 40, "To start press Enter", 900);

    }
    
}
