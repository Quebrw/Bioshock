import java.awt.Color;

import tools.*;
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
        window.setBackground(Color.black);

        // window size is constant
        window.setResizable(false);

        MyKeyHandler kH = new MyKeyHandler();

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);

        // The size of the Frame equals the GamePanel
        window.pack();

        // window is created in the center of the screen
        window.setLocationRelativeTo(null);

        window.setVisible(true);

        GameLoop gameLoop = new GameLoop(kH);
        Thread t1 = new Thread(gameLoop);
        t1.start();
    }
}
