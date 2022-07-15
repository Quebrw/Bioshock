package GUI;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.awt.Font;

import objects_graphics.*;

public class Titlescreen {

    private DObjects dO;

    private BufferedImage image;

    private int centerX = 1920/2;
    private int centerY = 1080/2;

    private int stringX;
    private int stringY;

    private int imageWidth = 500;
    private int imageHeight = 500;

    private int imageCenterX = centerX - imageWidth/2;
    private int imageCenterY = centerY - imageHeight/2;

    private String titleString = "EPIC POGOMAN";

    private DObjects dO2 = new DObjects();

    public Titlescreen() {

    }

    public void draw(Graphics2D g2) {

        image = dO2.returnImageGroundslam();

        drawString(g2, 80, titleString, 150);

        g2.setColor(Color.white);

        g2.drawImage(image, imageCenterX, imageCenterY, imageWidth, imageHeight, null);

        drawString(g2, 40, "Press Space to Enter", 900);

        

    }
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
