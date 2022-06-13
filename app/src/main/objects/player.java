package objects;
import tools.Vector2f;



public class player {


    public int health;
    Vector2f playerpos;
    float inertia = 2;                                                                              //seconds for which the player experiences inertia
    private int speed;
    private float currentSpeedR;
    private float currentSpeedL;

    public player(int health, Vector2f playerpos) {
        this.health = health;
        this.playerpos = playerpos;
        this.speed = 2;
    }
    
    //#region movement

    public void moveRight(long dTime) {
        float dTimeinSeconds = dTime / 1000000000;
        if (dTimeinSeconds <= this.inertia){
            double i = speed * Math.sin((Math.PI*dTimeinSeconds)/(2*inertia));                      //The player should feel inertia while starting to move
            currentSpeedR = (float)i;
            playerpos.increaseX(currentSpeedR, true);        
        }else{
            currentSpeedR = 2;
            playerpos.increaseX(speed, true);
        }
    }

    public void moveLeft(long dTime) {
        float dTimeinSeconds = dTime / 1000000000;
        if (dTimeinSeconds <= this.inertia){
            double i = speed * Math.sin((Math.PI*dTimeinSeconds)/(2*inertia));                      //The player should feel inertia while starting to move
            currentSpeedL = (float)i;
            playerpos.increaseX(currentSpeedL, false);        
        }else{
            currentSpeedL = 2;
            playerpos.increaseX(speed, false);
        }
    }

    public void abruptStopRight(long dTime){
        float dTimeinSeconds = dTime / 1000000000;
        if(currentSpeedR != 0){
            if(currentSpeedR <= inertia/4){
            currentSpeedR -= currentSpeedR * Math.sin((Math.PI*dTimeinSeconds)/(2*(inertia/4)));    //after stopping to move to the right, some inertia of movement should remain
            playerpos.increaseX(currentSpeedR, true);
        }else{
            currentSpeedR = 0;
        }
        }
    }
    
    public void abruptStopLight(long dTime){
        float dTimeinSeconds = dTime / 1000000000;
        if(currentSpeedL != 0){
            if(dTimeinSeconds <= inertia/4){
            currentSpeedL -= currentSpeedL * Math.sin((Math.PI*dTimeinSeconds)/(2*(inertia/4)));    //after stopping to move to the left, some inertia of movement should remain
            playerpos.increaseX(currentSpeedL, false);
            }else{
                currentSpeedL = 0;
            }
        }
    }

    //#endregion
}
