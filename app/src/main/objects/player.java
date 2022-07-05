package objects;
import tools.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends worldObjects{


    //#region Variables
    public int health;
    
    public Vector2f pos;
    
    //public float xpos;
    //public float ypos;    
    //private int width, height;
    
    public float inertia = .8f;                                                                              //seconds for which the player experiences inertia
    private int speed, jumpSpeed;
    private float currentSpeedR;
    private float currentSpeedL;
    public boolean actMovR, actMovL;
    public boolean touchingGround;
    public long jumpLenght = 1 * 1000000000;
    //public Vector2f despos;                                                                        //desired Position
    //#endregion
    
    //#region Constructors
    public Player(int health, Vector2f pos, int width, int height) {
        this.health = health;
        this.pos = pos;
        this.speed = 10;
        this.jumpSpeed = 15;
        this.width = width;
        this.height = height;
        this.setObjectType("player");
        this.touchingGround = false;
    }
    
    public Player() {
        this.health = 0;
        this.pos = new Vector2f();
        this.width = 0;
        this.height = 0;
        this.speed = 10;
        this.jumpSpeed = 15;
        this.despos = this.pos;
        this.setObjectType("player");
        this.touchingGround = false;
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
            despos.increaseX(speed*0.7f, true);
        }else{
            despos.increaseX(speed, true);
        }

        actMovR = true;
    }


    public void moveLeft(long dTime) {
        float dTimeinSeconds = dTime / 1000000000;

        if(dTimeinSeconds <= inertia){
            despos.increaseX(speed*0.7f, false);
        }else{
            despos.increaseX(speed, false);
        }
        actMovL = true;
    }

    public void jump(long dTime) {
        double i = jumpSpeed * Math.cos((Math.PI*dTime)/(2*jumpLenght));
        currentSpeedL = (float)i;
        despos.increaseY(currentSpeedL, true);        
    }

    public void ionlyfeelGravity() {
        this.despos.setYpos(this.despos.getYpos() - 10f);;
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
