import java.util.ArrayList;

import objects.Player;
import objects.worldObjects;
import tools.Collider;
import tools.MyKeyHandler;
import tools.Vector2f;
//import java.awt.Component;
import javax.swing.*;                                                           //Maybe specify later
//import tools.MyKeyHandler;
public class GameLoop extends JComponent implements Runnable {
    
  //#region Variables
    private boolean running = true;
    private float lastUpdate;
    private float updateRate = (1.0f/60.0f) * 1000000000.0f;
    private int i = 0;
    private long beganMoving;

    private Player P = new Player();
    private ArrayList<worldObjects> sObjects;
    private MyKeyHandler kH;

    //#endregion

    public GameLoop(MyKeyHandler kHin) {
      this.kH = kHin;
    }

    @Override
    public void run() {

      //Most of these implementation should later be handled by a load Class
      P.setHeight(20.0f);                   
      P.setWidth(40.0f);
      P.setPos(new Vector2f(-10f,-10f));

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
      
      if(i == 60){                                                              //tests FrameRate
        System.out.println(time / 1000000000);
        i = 0;
      }else{
        i++;
      }
      //updateCollision();
      updatePlayerMovement();

      updatePositions();
    }

    private void updatePlayerMovement() {
        if(kH.D_PRESSED == true && P.actMovL == false){     //checks if Movement right is requested and whether it interfering with previously requested Movement    

            if(P.actMovR == false){beganMoving = System.nanoTime();}  //if the object just started the active Movement in this direction the time is taken; this is required for a later function
            P.moveRight(beganMoving - System.nanoTime());

        }else if(kH.A_PRESSED == true && P.actMovR == false){   //checks if Movement right is requested and whether it interfering with previously requested Movement  

          if(P.actMovL == false){beganMoving = System.nanoTime();}  //if the object just started the active Movement in this direction the time is taken; this is required for a later function
          P.moveLeft(beganMoving - System.nanoTime());

        }else{
          if(P.isMovingRight() == true){
            P.abruptStopRight(kH.D_releaseTime - System.nanoTime());
          }
          if(P.isMovingLeft()){
            P.abruptStopLeft(kH.A_releaseTime - System.nanoTime());
          }
        }
    }

    private void updateCollision() {                                              //currently just Testcode inside
      
      Collider.getCollisisions(P, sObjects);

      // worldObjects R = new worldObjects();
      // if(Collider.isColliding(P, R) == true){
      //   System.out.println("yes");
      //   P.setPos(new Vector2f(P.getPos().getXpos()+0.01667f, -10f));
      // } 

    }

    private void updatePositions(){
      P.updatePosition();

    }

}
