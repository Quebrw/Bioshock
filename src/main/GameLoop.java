package src.main;

import src.tools.Time;

public class GameLoop implements Runnable{
    
    private boolean running;
    private float lastUpdate;
    private float updateRate; 

    @Override
    public void run() {
        while (running == true) {
            float currentTime = System.nanoTime();
            if(currentTime - lastUpdate <= updateRate){
              update();
              lastUpdate = Time.time();
            }
            
          }
    }

    public void update(){

    }

    public void updateMovement() {
        
    }

    public void updateCollision() {
        
    }

}
