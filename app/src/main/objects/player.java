package objects;
import tools.Vector2f;
import java.awt.*;


public class Player extends worldObjects{
    //#region Variables
    public int health;

    //_____Movement_______
    public float inertia = .8f;                                                                              //seconds for which the player experiences inertia
    private int speed, jumpSpeed;
    public boolean actMovR, actMovL, upsidedown;
    public boolean touchingGround;
    public long jumpLenght = 1 * 1000000000;
    public float gravityStrenght;
    //#endregion
    
    //#region Constructors
    public Player(int health, Vector2f pos, int width, int height) {
        this.health = health;
        //this.pos = pos;
        this.xpos = pos.getXpos();
        this.ypos = pos.getYpos();
        this.speed = 10;
        this.jumpSpeed = 15;
        this.width = width;
        this.height = height;
        this.setObjectType("player");
        this.touchingGround = false;
    }
    
    public Player() {
        this.health = 0;
        this.xpos = 0;
        this.ypos = 0;
        this.width = 0;
        this.height = 0;
        this.speed = 10;
        this.jumpSpeed = 15;
        this.gravityStrenght = 10.0f;
        upsidedown = false;
        this.despos = new Vector2f();
        this.setObjectType("player");
        this.touchingGround = false;
    }
    //#endregion

    
    
    //#region movement

    public void updatePosition() {
        this.xpos = this.despos.getXpos();
        this.ypos = this.despos.getYpos();
        //this.pos = new Vector2f(this.xpos, this.ypos);
    }
    
    /* 
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
    */
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
        float jSpeed = (float)i;
        despos.increaseY(jSpeed, true);        
    }

    public void ionlyfeelGravity() {
        //this.despos.setYpos(this.despos.getYpos() - gravityStrenght);
        this.despos.increaseY(gravityStrenght, upsidedown);
    }

    //#endregion

    public void draw(Graphics g2) {
        
    g2.setColor(Color.blue);

        g2.fillRect((int) this.xpos,(int) this.ypos,this.width,this.height);

    }

    //#region GetSet

    public int getSpeed() {
        return speed;
    }

    //#endregion
}
