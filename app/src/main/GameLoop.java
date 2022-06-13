import objects.player;
import objects.worldObjects;
import tools.Collider;
import tools.Vector2f;

public class GameLoop implements Runnable{
    
    private boolean running = true;
    private float lastUpdate;
    private float updateRate = (1.0f/60.0f) * 1000000000.0f;
    private int i = 0;

    // public player P = new player();
    
    @Override
    public void run() {

      // P.setHeight(20.0f);
      // P.setWidth(40.0f);
      // P.setPos(new Vector2f(-10f,-10f));
      
      while (running == true) {
          float currentTime = System.nanoTime();
          float dTime = currentTime - lastUpdate;
          if( dTime >= updateRate){
              update(currentTime);
              lastUpdate = System.nanoTime();
            }
            
          }
    }

    public void update(float time){
      
      if(i == 60){                                                              //tests FrameRate
        System.out.println(time / 1000000000);
        i = 0;
      }else{
        i++;
      }
      updateCollision();
    }

    public void updateMovement() {
        
    }

    public void updateCollision() {                                              //currently just Testcode inside


      // worldObjects R = new worldObjects();
      // if(Collider.isColliding(P, R) == true){
      //   System.out.println("yes");
      //   P.setPos(new Vector2f(P.getPos().getXpos()+0.01667f, -10f));
      // } 

    }

}
