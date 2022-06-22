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
      updateMovement();

      updatePositions();
    }

    private void updateMovement() {
        if(kH.W_PRESSED == true){
          P.
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
