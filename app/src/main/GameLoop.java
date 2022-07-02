//import java.util.ArrayList;

import objects.Player;
//import objects.worldObjects;
//import tools.Collider;
import tools.MyKeyHandler;
import tools.Vector2f;
//import java.awt.Component;
import javax.swing.*;   
//import java.awt.Graphics;                                                        //Maybe specify later

import GUI.GamePanel;
//import tools.MyKeyHandler;
public class GameLoop extends JComponent implements Runnable {
    
  //#region Variables
    private boolean running = true;
    private float lastUpdate;
    private float updateRate = (1.0f/60.0f) * 1000000000.0f;
    private int i = 0;
    private long beganMoving;

    private Player P = new Player();
    //private ArrayList<worldObjects> sObjects;
    private MyKeyHandler kH;
    private GamePanel gP;

    //#endregion

    public GameLoop(MyKeyHandler kHin, GamePanel gamePanel) {
      this.kH = kHin;
      this.gP = gamePanel;
    }

    @Override
    public void run() {

      //Most of these implementation should later be handled by a load Class
      P.setHeight(100.0f);                   
      P.setWidth(100.0f);
      P.setPos(new Vector2f(500f,500f));
      //this.setFocusable(true);
      //this.addKeyListener(kH);

      //This Loop calls the update Function every 1/60th of a second
      while (running == true) {
          float currentTime = System.nanoTime();
          float dTime = currentTime - lastUpdate;
          if( dTime >= updateRate){
              update(currentTime);
              lastUpdate = System.nanoTime();
            }

    
            
      }
    }

    //General update method; streamlines and organises specific updates; takes in time at which the update is called for convienience
    public void update(float time){
      
      System.out.println(time);

      updatePlayerMovement();

      updateCollision();

      updatePositions();

      updateFrame();

    }

    private void updatePlayerMovement() {
      /* 
      if(kH.D_PRESSED == true && P.actMovL == false){     //checks if Movement right is requested and whether it interfering with previously requested Movement    
            if(P.actMovR == false){beganMoving = System.nanoTime();}  //if the object just started the active Movement in this direction the time is taken; this is required for a later function
            P.moveRight(System.nanoTime() - beganMoving);
            

        }else if(kH.A_PRESSED == true && P.actMovR == false){   //checks if Movement right is requested and whether it interfering with previously requested Movement  

          if(P.actMovL == false){beganMoving = System.nanoTime();}  //if the object just started the active Movement in this direction the time is taken; this is required for a later function
          P.moveLeft(System.nanoTime()-beganMoving);

        }else{
          System.err.println(P.isMovingRight());
          if(P.isMovingRight() == true){
            System.out.println("yes");
            P.abruptStopRight(System.nanoTime() - kH.D_releaseTime);
          }
          if(P.isMovingLeft() == true){
            P.abruptStopLeft(System.nanoTime() - kH.A_releaseTime);
          }
        }
        */
        if(kH.D_PRESSED == true && P.actMovL == false){
          if(P.actMovR == false){beganMoving = System.nanoTime();}
          P.moveRight(System.nanoTime() - beganMoving);
        }
        if(kH.A_PRESSED == true){
          if(P.actMovR == false){beganMoving = System.nanoTime();}
          P.moveLeft(System.nanoTime() - beganMoving);
        }
    }

    private void updateCollision() {                                              //currently just Testcode inside
      
      //Collider.getCollisisions(P, sObjects);

      // worldObjects R = new worldObjects();
      // if(Collider.isColliding(P, R) == true){
      //   System.out.println("yes");
      //   P.setPos(new Vector2f(P.getPos().getXpos()+0.01667f, -10f));
      // } 

    }

    private void updatePositions(){
      P.updatePosition();

    }
    
    private void updateFrame() {
      int x = (int)P.xpos;
      int y = (int)P.getPos().getYpos();
      int w = (int)P.getWidth();
      int h = (int)P.getHeight();
      gP.uGamePanel(x,y,w,h);
      gP.repaint();
    }

}
