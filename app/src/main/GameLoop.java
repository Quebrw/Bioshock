import java.util.ArrayList;

import objects.Player;
import objects.worldObjects;
import tools.Collider;
import tools.MyKeyHandler;
import tools.Vector2f;
//import java.awt.Component;
import javax.swing.*;   
//import java.awt.Graphics;                                                        //Maybe specify later
import javax.swing.plaf.basic.BasicGraphicsUtils;

import GUI.GamePanel;
//import tools.MyKeyHandler;
public class GameLoop extends JComponent implements Runnable {
    
  //#region Variables
    private boolean running = true;
    private float lastUpdate;
    private float updateRate = (1.0f/60.0f) * 1000000000.0f;
    private boolean inertiaR, inertiaL;
    private long stoppedMovingR, stoppedMovingL;
    private long beganMoving;

    private Player P = new Player();
    //private ArrayList<worldObjects> sObjects;
    private MyKeyHandler kH;
    private GamePanel gP;
    private ArrayList<worldObjects> sObjects = new ArrayList<worldObjects>();

    //#endregion

    public GameLoop(MyKeyHandler kHin, GamePanel gamePanel) {
      this.kH = kHin;
      this.gP = gamePanel;
    }

    @Override
    public void run() {

      //Most of these implementation should later be handled by a load Class
      P.setHeight(100);                   
      P.setWidth(100);
      P.setPos(new Vector2f(500f,500f));
      worldObjects box = new worldObjects(100,100, new Vector2f(2000.0f,500.0f), "box");
      sObjects.clear();
      sObjects.add(P);
      sObjects.add(box);
      System.out.println(sObjects.size());
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

        //If the Player is not already moving in another direction, he will start moving right/left
        if(kH.D_PRESSED == true && P.actMovL == false){
          if(P.actMovR == false){beganMoving = System.nanoTime();}
          //gets the time for which this active movement has been underway
          P.moveRight(System.nanoTime() - beganMoving);
        }
        if(kH.A_PRESSED == true && P.actMovR == false){
          if(P.actMovL == false){beganMoving = System.nanoTime();}
          P.moveLeft(System.nanoTime() - beganMoving);
        }
        //handles inertia of movement
        if(kH.D_PRESSED == false && P.actMovR	 == true){
          P.actMovR = false;
          if((System.nanoTime() - beganMoving)/1000000000 >= 0.5){inertiaR = true;}
          stoppedMovingR = System.nanoTime();
        }
        if(kH.A_PRESSED == false && P.actMovL == true){
          P.actMovL = false;
          if((System.nanoTime() - beganMoving)/1000000000 >= 0.5){inertiaL = true;}
          stoppedMovingL = System.nanoTime();
        }
        if(inertiaR == true && kH.D_PRESSED == false){
          P.despos.increaseX(P.getSpeed()/2, true);
          if((System.nanoTime() - stoppedMovingR) >= (0.15)*1000000000){
            inertiaR = false;
          }
        }
        if(inertiaL == true && kH.A_PRESSED == false){
          P.despos.increaseX(P.getSpeed()/2, false);
          if((System.nanoTime() - stoppedMovingL) >= (0.15)*1000000000){
            inertiaL = false;
          }
        }
    }

    private void updateCollision() {                                              //currently just Testcode inside
      
      ArrayList<worldObjects> colliders = Collider.getCollisisions(P, sObjects);

      if(colliders.size() > 0){
        for(int j = 0; j >= colliders.size(); j++){
        switch(colliders.get(j).getObjectType()){
          
          case "generic":
          break;

          case "box":
            boolean isColliding = true;
            Vector2f move = P.despos.getDifference(P.pos);
            while(isColliding == true){
              P.despos.subtract(move, 0.2f);
              if(Collider.isColliding(P, colliders.get(j))== false){
                isColliding = false;
              }
            }
          break;

        }
      }
    }

    }

    private void updatePositions(){
      P.updatePosition();

    }

    private void updateFrame() {
      int x = (int)P.xpos;
      int y = (int)P.getPos().getYpos();
      int w = P.getWidth();
      int h = P.getHeight();
      gP.uGamePanel(x,y,w,h);
      gP.repaint();
    }

}
