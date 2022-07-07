package test;
import java.awt.Color;

//import tools.*;
import javax.swing.JFrame;

import GUI.GamePanel;
import tools.MyKeyHandler;

public class Main extends JFrame{

    public static void main(String[] args) {

        JFrame window = new JFrame();

        // sets title
        window.setTitle("Das ist unser Titel");

        // allows the user to exit the window
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // background color
        window.setBackground(Color.red);

        // window size is constant
        window.setResizable(false);

        MyKeyHandler kH = new MyKeyHandler();

        GamePanel gamePanel = new GamePanel(kH);
        // Implements the GamePanel to the Frame
        window.add(gamePanel);

        // The size of the Frame equals the GamePanel
        window.pack();

        // window is created in the center of the screen
        window.setLocationRelativeTo(null);

        // Turns the frame with its content visible
        window.setVisible(true);

        GameLoop gameLoop = new GameLoop(kH, gamePanel);
        Thread t1 = new Thread(gameLoop);
        t1.start();
    }
}
