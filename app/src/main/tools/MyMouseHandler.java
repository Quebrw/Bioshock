package tools;

import GUI.GamePanel;
import Gamestate.Gamestate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseHandler implements MouseListener, MouseMotionListener{

    GamePanel gP;

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Bsss");
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Gamestate.state = Gamestate.PLAYING;
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
