package tools;
import java.awt.event.*;

public class MyKeyHandler implements KeyListener{

    public boolean Wpressed, Apressed, Spressed, Dpressed, SPACEpressed, SHIFTpressed;
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("W");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public MyKeyHandler() {
        Wpressed = false;
        Apressed = false;
        Spressed = false;
        Dpressed = false;
        SPACEpressed = false;
        SHIFTpressed = false;
    }

}