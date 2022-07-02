package objects;
import tools.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends worldObjects{


    //#region Variables
    public int health;
    
    public Vector2f pos;
    public float xpos;
    public float ypos;
    
    private int width;
    private int height;
    
    float inertia = .8f;                                                                              //seconds for which the player experiences inertia
    private int speed;
    private float currentSpeedR;
    private float currentSpeedL;
    public boolean actMovR, actMovL;
    public Vector2f despos;                                                                        //desired Position
    //#endregion
    
    //#region Constructors
    public Player(int health, Vector2f pos, int width, int height) {
        this.health = health;
        this.pos = pos;
        this.speed = 50;
        this.width = width;
        this.height = height;
        
        
    }
    
    public Player() {
        this.health = 0;
        this.pos = new Vector2f();
        this.width = 0;
        this.height = 0;
        this.speed = 30;
        this.despos = this.pos;
    }
    //#endregion

    
    
    //#region movement

    public void updatePosition() {
        this.xpos = this.despos.getXpos();
        this.ypos = this.despos.getYpos();
        this.pos = new Vector2f(this.xpos, this.ypos);
    }
    
    public boolean isMovingLeft(){
        if(currentSpeedL != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isMovingRight() {
        if(currentSpeedR != 0){
            return true;
        }else{
            return false;
        }
    }

    public void moveRight(long dTime) {
         
        float dTimeinSeconds = dTime / 1000000000;

        if(dTimeinSeconds <= inertia){
            despos.increaseX(speed/2, true);
        }else{
            despos.increaseX(speed, true);
        }

        /*
        if (dTimeinSeconds <= this.inertia){
            double i = speed * Math.sin((Math.PI*dTimeinSeconds)/(2*inertia));                      //The player should feel inertia while starting to move
            currentSpeedR = (float)i;
            despos.increaseX(currentSpeedR, true);        
        }else{
            currentSpeedR = 2;
            despos.increaseX(speed, true);
        }
        */
        
        actMovR = true;
    }


    public void moveLeft(long dTime) {
        float dTimeinSeconds = dTime / 1000000000;

        if(dTimeinSeconds <= inertia){
            despos.increaseX(speed/2, false);
        }else{
            despos.increaseX(speed, false);
        }
        /* 
        if (dTimeinSeconds <= this.inertia){
            double i = speed * Math.sin((Math.PI*dTimeinSeconds)/(2*inertia));                      //The player should feel inertia while starting to move
            currentSpeedL = (float)i;
            despos.increaseX(currentSpeedL, false);        
        }else{
            currentSpeedL = 2;
            despos.increaseX(speed, false);
        }
        */
        actMovL = true;
    }

    public void abruptStopRight(long dTime){
        actMovR = false;
        float dTimeinSeconds = dTime / 1000000000;
        System.out.println(dTimeinSeconds);
        if(currentSpeedR != 0){
            if(dTimeinSeconds <= inertia/4){
            currentSpeedR -= speed * Math.sin((Math.PI*dTimeinSeconds)/(2*(inertia/4)));    //after stopping to move to the right, some inertia of movement should remain
            despos.increaseX(currentSpeedR, true);
        }else{
            currentSpeedR = 0;
        }
        }
    }
    
    public void abruptStopLeft(long dTime){
        actMovL = false;
        float dTimeinSeconds = dTime / 1000000000;
        if(currentSpeedL != 0){
            if(dTimeinSeconds <= inertia/4){
            currentSpeedL -= speed * Math.sin((Math.PI*dTimeinSeconds)/(2*(inertia/4)));    //after stopping to move to the left, some inertia of movement should remain
            despos.increaseX(currentSpeedL, false);
            }else{
                currentSpeedL = 0;
            }
        }
    }


    //#endregion

    public void draw(Graphics g2) {
        BufferedImage image = null;
    }

    //#region GetSet

    public int getSpeed() {
        return speed;
    }

    //#endregion
}
