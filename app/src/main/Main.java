import java.awt.Color;

import javax.swing.JFrame;

import GUI.GamePanel;

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

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);

        // window is created in the center of the screen
        window.setLocationRelativeTo(null);

        // The size of the Frame equals the GamePanel
        window.pack();

        window.setVisible(true);

        // GameLoop gameLoop = new GameLoop();
        // Thread t1 = new Thread(gameLoop);
        // t1.start();
    }
}
