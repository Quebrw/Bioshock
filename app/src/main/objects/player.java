package objects;
import tools.Vector2f;



public class Player extends worldObjects{


    //#region Variables
    public int health;

    public Vector2f pos;
    
    private int width;
    private int height;

    float inertia = 2;                                                                              //seconds for which the player experiences inertia
    private int speed;
    private float currentSpeedR;
    private float currentSpeedL;
    private Vector2f despos;                                                                        //desired Position
    //#endregion

    //#region Constructors
    public Player(int health, Vector2f pos, int width, int height) {
        this.health = health;
        this.pos = pos;
        this.speed = 2;
        this.width = width;
        this.height = height;


    }

    public Player() {
        this.health = 0;
        this.pos = new Vector2f();
        this.width = 0;
        this.height = 0;
        this.speed = 0;
        this.despos = this.pos;
    }
    //#endregion
    
    //#region movement

    public void moveRight(long dTime) {
        float dTimeinSeconds = dTime / 1000000000;
        if (dTimeinSeconds <= this.inertia){
            double i = speed * Math.sin((Math.PI*dTimeinSeconds)/(2*inertia));                      //The player should feel inertia while starting to move
            currentSpeedR = (float)i;
            despos.increaseX(currentSpeedR, true);        
        }else{
            currentSpeedR = 2;
            despos.increaseX(speed, true);
        }
    }

    public void moveLeft(long dTime) {
        float dTimeinSeconds = dTime / 1000000000;
        if (dTimeinSeconds <= this.inertia){
            double i = speed * Math.sin((Math.PI*dTimeinSeconds)/(2*inertia));                      //The player should feel inertia while starting to move
            currentSpeedL = (float)i;
            despos.increaseX(currentSpeedL, false);        
        }else{
            currentSpeedL = 2;
            despos.increaseX(speed, false);
        }
    }

    public void abruptStopRight(long dTime){
        float dTimeinSeconds = dTime / 1000000000;
        if(currentSpeedR != 0){
            if(currentSpeedR <= inertia/4){
            currentSpeedR -= currentSpeedR * Math.sin((Math.PI*dTimeinSeconds)/(2*(inertia/4)));    //after stopping to move to the right, some inertia of movement should remain
            despos.increaseX(currentSpeedR, true);
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
            despos.increaseX(currentSpeedL, false);
            }else{
                currentSpeedL = 0;
            }
        }
    }

    public void updatePosition() {
        pos = despos;
        
    }

    //#endregion
}
