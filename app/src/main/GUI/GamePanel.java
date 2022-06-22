package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tools.MyKeyHandler;

import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel {

    // 
    public int screenWidth = 1920;

    public int screenHeight = 1080;

    public GamePanel() {

        // size of the GamePanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        // sets background color of the GamePanel to black
        this.setBackground(Color.black);

        MyKeyHandler kH = new MyKeyHandler();
        this.setFocusable(true);
        this.addKeyListener(kH);
    }

    


    
}
