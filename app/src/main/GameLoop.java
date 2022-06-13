public class GameLoop implements Runnable{
    
    private boolean running = true;
    private float lastUpdate;
    private float updateRate = (1.0f/60.0f) * 1000000000.0f;
    private int i = 0;

    @Override
    public void run() {
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
      
      if(i == 60){
        System.out.println(time / 1000000000);
        i = 0;
      }else{
        i++;
      }
    }

    public void updateMovement() {
        
    }

    public void updateCollision() {
        
    }

}
