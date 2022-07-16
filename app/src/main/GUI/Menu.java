package GUI;


//----Graphical components----//

import java.awt.Graphics2D;

import java.awt.Color;

import java.awt.Font;

import java.awt.image.BufferedImage;

import java.util.ArrayList;

//----Self created----//

import objects_graphics.DObjects;

public class Menu{

//----Images----//

    // Contains images
    DObjects dO4 = new DObjects();

    // Background
    BufferedImage menuBackground = dO4.returnMenuScreen();

    private int centerX = 1920/2;
    private int centerY = 1080/2;
    private int imageWidth = 1920;
    private int imageHeight = 1080;
    private int offsetX = imageWidth/2;
    private int offsetY = imageHeight/2;

    // Title
    final String menu = "MENU";

    // Cursor
    BufferedImage CursorImage = dO4.returnImageGrabR();

    private int imageWidthCursor = 50;
    private int imageHeightCursor = 40;

    // Used for cursor inputs
    public static int userInput;

    // "Buttons"
    ArrayList<MenuButtons> menuButtons = new ArrayList<MenuButtons>();

        MenuButtons b_play = new MenuButtons("RESUME", 560);
        MenuButtons b_quit = new MenuButtons("QUIT", 660);
    

    public Menu() {

        // Adds the Buttons the Menu when created
        addMenuButtons();

    }
    // Draw fucnction
    public void draw(Graphics2D g2) {

        // Background
        g2.drawImage(menuBackground, centerX - offsetX, centerY - offsetY, imageWidth, imageHeight, null);

        // Title - Menu
        titleString(g2);

        // MenuButtons Arraylist contains buttons that should be drawn
        for (int i = 0; i < menuButtons.size(); i++) {

            //draws menuButtons
            menuButtons.get(i).draw(g2, menuButtons.get(i).y, menuButtons.get(i).text);

        }

        // draws cursor
        drawCursor(g2);

    }

    // Function that gets the width of a text and returns it
    public int getStringWidth(String text, Graphics2D g2) {

        int centerX = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()/(2);

        return centerX;
    }

    // Function that gets the height of a text and returns it
    public int getStringHeight(String text, Graphics2D g2) {

        int centerY = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight()/(2);

        return centerY;
    }

    // Function to draw a title
    public void titleString(Graphics2D g2) {

        // Font options
        g2.setFont(new Font("Serif", Font.BOLD, 86));

        // Centers the text
        int reallyCenteredX = centerX - getStringWidth(menu, g2);

        // Text should appear in white color
        g2.setColor(Color.white);

        // draws title
        g2.drawString(menu, reallyCenteredX, 230);
    }

    // Adds buttons to the Arraylist
    public void addMenuButtons() {

        menuButtons.add(b_play);
        menuButtons.add(b_quit);
    }

    // Function to draw a cursor
    public void drawCursor(Graphics2D g2) {

        // Depending on what the user inputs the cursor should appear at a different "Button"
        if (userInput == 0) {

            // draws cursor next to the button for userinput == 0 --> next to Resume
            g2.drawImage(CursorImage, 1920/2 - menuButtons.get(0).getStringWidth("Resume", g2) - imageWidthCursor - 20,  menuButtons.get(0).y - imageHeightCursor, 50, 50, null);

        } else if (userInput == 1) {

        // draws cursor next to the button for userinput == 0 --> next to Resume
            g2.drawImage(CursorImage, 1920/2 - menuButtons.get(1).getStringWidth("Quit", g2) - imageWidthCursor - 20,  menuButtons.get(1).y - imageHeightCursor, 50, 50, null);

        } 
    }
}