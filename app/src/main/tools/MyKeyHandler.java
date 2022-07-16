package tools;
import java.awt.event.*;

import GUI.GamePanel;
import GUI.Menu;
import Gamestate.Gamestate;

public class MyKeyHandler implements KeyListener{

    public boolean W_PRESSED, A_PRESSED, S_PRESSED, D_PRESSED, SPACE_PRESSED, SHIFT_PRESSED, ESCAPE_PRESSED, ENTER_PRESSED, UP_PRESSED, DOWN_PRESSED;
    public boolean enabled;               //whether a certian key is being precced at this moment
    public long A_releaseTime, D_releaseTime;

    GamePanel gP;

    public MyKeyHandler(GamePanel gP) {

        this.gP = gP;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(enabled == true){
            if (e.getKeyCode() == KeyEvent.VK_W) {
                W_PRESSED = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_A) {
                A_PRESSED = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_S) {
                S_PRESSED = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_D) {
                D_PRESSED = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                SHIFT_PRESSED = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                SPACE_PRESSED = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                ESCAPE_PRESSED = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ENTER_PRESSED = true;

                switch (Gamestate.state) {
                    case MENU:

                    if (Menu.userInput == 0) {

                        Gamestate.state = Gamestate.PLAYING;
                    } 
                    else if (Menu.userInput == 1) {
    
                        Gamestate.state = Gamestate.OPTIONS;
                    }
                    else if (Menu.userInput == 2) {
                        
                        Gamestate.state = Gamestate.QUIT;
    
                    }
                    break;
                    default:
                    break;
                }

                
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                UP_PRESSED = true;

                if (Gamestate.state == Gamestate.MENU) {

                    Menu.userInput--;
                    
                    if (Menu.userInput < 0)
                        Menu.userInput = 2;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                DOWN_PRESSED = true;

                if (Gamestate.state == Gamestate.MENU) {

                    Menu.userInput++;
                    if (Menu.userInput > 2)
                        Menu.userInput = 0;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //if(enabled == true){
            if (e.getKeyCode() == KeyEvent.VK_W) {
                W_PRESSED = false;
            }

            if (e.getKeyCode() == KeyEvent.VK_A) {
                A_PRESSED = false;
                // A_releaseTime = System.nanoTime();
            }

            if (e.getKeyCode() == KeyEvent.VK_S) {
                S_PRESSED = false;
            }

            if (e.getKeyCode() == KeyEvent.VK_D) {
                D_PRESSED = false;
                // D_releaseTime = System.nanoTime();
            }

            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                SHIFT_PRESSED = false;
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                SPACE_PRESSED = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                ESCAPE_PRESSED = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ENTER_PRESSED = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                UP_PRESSED = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                DOWN_PRESSED = false;
            }
        //}
    }

    public MyKeyHandler() {
        W_PRESSED = false;
        A_PRESSED = false;
        S_PRESSED = false;
        D_PRESSED = false;
        SPACE_PRESSED = false;
        SHIFT_PRESSED = false;
        ESCAPE_PRESSED = false;

        enabled = true;
    }

}