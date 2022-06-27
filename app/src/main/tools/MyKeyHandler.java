package tools;
import java.awt.event.*;

public class MyKeyHandler implements KeyListener{

    public boolean W_PRESSED, A_PRESSED, S_PRESSED, D_PRESSED, SPACE_PRESSED, SHIFT_PRESSED;               //whether a certian key is being precced at this moment
    public long A_releaseTime, D_releaseTime;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W){
            W_PRESSED = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_A){
            A_PRESSED = true;
            System.out.println("A-in");
        }

        if(e.getKeyCode() == KeyEvent.VK_S){
            S_PRESSED = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            D_PRESSED = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            SHIFT_PRESSED = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            SPACE_PRESSED = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W){
            W_PRESSED = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_A){
            A_PRESSED = false;
            A_releaseTime = System.nanoTime();
        }

        if(e.getKeyCode() == KeyEvent.VK_S){
            S_PRESSED = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            D_PRESSED = false;
            D_releaseTime = System.nanoTime();
        }

        if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            SHIFT_PRESSED = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            SPACE_PRESSED = false;
        }
        
    }

    public MyKeyHandler() {
        W_PRESSED = false;
        A_PRESSED = false;
        S_PRESSED = false;
        D_PRESSED = false;
        SPACE_PRESSED = false;
        SHIFT_PRESSED = false;
    }

}