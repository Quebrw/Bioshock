package test;
import java.util.ArrayList;

import objects.Player;
import objects.worldObjects;
import tools.Collider;
import tools.MyKeyHandler;
import tools.Vector2f;
//import java.awt.Component;
import javax.swing.*;   
//import java.awt.Graphics;  
//Maybe specify later

//import java.awt.Graphics2D;


import GUI.GamePanel;
//import tools.MyKeyHandler;
public class GameLoop extends JComponent implements Runnable {
    
  //#region Variables

  //______FRAMEUPDATE___________
  private float lastUpdate;
  private float updateRate = (1.0f/60.0f) * 1000000000.0f;
  
  //______GLOBAL_ENTITIES_______
  private MyKeyHandler kH;
  private GamePanel gP;
  private ArrayList<worldObjects> sObjects = new ArrayList<worldObjects>();
  private int[] worldGrid = new int[2];
  private boolean sceneChange = false;
  
  //______SPECIFIC_ENTITIES_____
  private worldObjects refGround = new worldObjects();
  
  //_______PLAYER_______________
  public Player P = new Player();
  private boolean running = true;
  private boolean inertiaR, inertiaL;
  private long stoppedMovingR, stoppedMovingL;
  private long beganMoving, beganJump;

    //#endregion

    public GameLoop(MyKeyHandler kHin, GamePanel gamePanel) {
      this.kH = kHin;
      this.gP = gamePanel;
    }

    @Override
    public void run() {

      //Most of these implementations should later be handled by a load Class
      P.setHeight(50);                   
      P.setWidth(50);
      P.xpos = 500f;
      P.ypos = 500f;
      P.pos.setXpos(P.xpos);
      P.pos.setYpos(P.ypos); 
      worldObjects box = new worldObjects(100,1500, new Vector2f(200.0f,399.0f), "box");
      worldObjects box2 = new worldObjects(100,3000, new Vector2f(-100.0f,-100.0f), "box");
      
      
      refGround.setObjectType("generic");
      refGround.xpos = -100.0f;
      refGround.width = 3000;
      refGround.ypos = -100f;
      refGround.height = 1; 

      sObjects.clear();
      sObjects.add(P);
      sObjects.add(box);
      sObjects.add(box2);

      System.out.println(sObjects.size());
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
      
      System.out.println(time);
      
      updatePlayerMovement();
      
      updateScene();

      updateCollision();
      
      updatePositions();
      
      updateFrame();

    }

    private void updatePlayerMovement() {

        //------------------------------------------------------------------------------------------------------------------------------------------------
        //The Player starts sprinting after 2 seconds, when stopping to sprint, they will experience a certiant inertia of movement because of their speed
        //------------------------------------------------------------------------------------------------------------------------------------------------
        /* 
        if((System.nanoTime() - beganJump) < P.jumpLenght/3){
          kH.enabled = false;
          kH.SPACE_PRESSED = false;
        }
        if((System.nanoTime() - beganJump) >= P.jumpLenght/3){
          kH.enabled = true;
        }
        */
        //If the Player is not already moving in another direction, he will start moving right/left
        if(kH.D_PRESSED == true && P.actMovL == false){
          if(P.actMovR == false){beganMoving = System.nanoTime();}
          //gets the time for which this active movement has been underway
          P.moveRight(System.nanoTime() - beganMoving);
        }
        if(kH.A_PRESSED == true && P.actMovR == false){
          if(P.actMovL == false){beganMoving = System.nanoTime();}
          P.moveLeft(System.nanoTime() - beganMoving);
        }
        //handles inertia of movement
        if(kH.D_PRESSED == false && P.actMovR	 == true){
          P.actMovR = false;
          if((System.nanoTime() - beganMoving)/1000000000 >= 0.5){inertiaR = true;}
          stoppedMovingR = System.nanoTime();
        }
        if(kH.A_PRESSED == false && P.actMovL == true){
          P.actMovL = false;
          if((System.nanoTime() - beganMoving)/1000000000 >= 0.5){inertiaL = true;}
          stoppedMovingL = System.nanoTime();
        }
        if(inertiaR == true && kH.D_PRESSED == false){
          P.despos.increaseX(P.getSpeed()/2, true);
          if((System.nanoTime() - stoppedMovingR) >= (0.15)*1000000000){
            inertiaR = false;
          }
        }
        if(inertiaL == true && kH.A_PRESSED == false){
          P.despos.increaseX(P.getSpeed()/2, false);
          if((System.nanoTime() - stoppedMovingL) >= (0.15)*1000000000){
            inertiaL = false;
          }
        }

        //executes Gravity when necessary
        if(P.touchingGround == false){
          P.ionlyfeelGravity();
        }

        //initiates the jump
        if(kH.SPACE_PRESSED == true && P.touchingGround == true){
          beganJump = System.nanoTime();
          P.touchingGround = false;
        }

        //executes the jump
        if((System.nanoTime() - beganJump) < P.jumpLenght){
          P.jump(System.nanoTime() - beganJump);
        }
        
        //checks if the player has stepped off a platform and should therefore experience gravity
        if((P.xpos + P.width) < refGround.xpos || P.xpos > (refGround.xpos + refGround.width)){
          P.touchingGround = false;
        }
    }

    //may be unnecessary
    private void updateScene() {
      sObjects.set(0, P);
    }

    private void updateCollision() {  //currently only checking Player collision
      
      //gets a List of all Objects that are currently touching the player
      ArrayList<worldObjects> colliders = Collider.getCollisisions(P, sObjects);
      System.out.println(colliders + "|" + colliders.size()); //debug
      //safeguard so theres no out of bounds exception
      if(colliders.size() >= 1){
        for(int j = 0; j < colliders.size(); j++){
          //for every colliding object the Type of collision is checked
          switch(colliders.get(j).getObjectType()){
          
            case "generic":
            break;

            //for boxcollisions the player is supposed to not be able to move through
            case "box":
              boolean isColliding = true;
              P.pos.setXpos(P.xpos);
              P.pos.setYpos(P.ypos);
              Vector2f move = P.despos.getDifference(P.pos);
              //sets the player back so that its as close to the colliding object as possible without touching it
              while(isColliding == true){
                P.despos.subtract(move, 0.1f);
                if(Collider.isColliding(P, colliders.get(j))== false){
                  isColliding = false;
                }
              }
              //if the Player touches Ground, gravity has to be turned off, because it would cause constant collision and mess up the movement
              if(P.ypos > (colliders.get(j).ypos + colliders.get(j).height) && ((P.xpos >= colliders.get(j).xpos && P.xpos <= (colliders.get(j).xpos + colliders.get(j).width))||((P.xpos + P.width) >= colliders.get(j).xpos && (P.xpos + P.width) <= (colliders.get(j).xpos + colliders.get(j).width)))){
                P.touchingGround = true;
                //there are 2 ways a player can leave a surface: per jumping or per stepping off the platform. To account for the second one a copy of the current surface's x-Dimensions is made for reference
                refGround.xpos = colliders.get(j).xpos;
                refGround.width = colliders.get(j).width;
              }
            break;

            //#region SceneTriggers

            case "rightTrigger":
              worldGrid[0] += 1;
              sceneChange = true;
            break;

            case "leftTrigger":
              worldGrid[0] -= 1;
              sceneChange = true;
            break;

            case "upTrigger":
              worldGrid[1] += 1;
              sceneChange = true;
            break;

            case "downTrigger":
              worldGrid[1] -= 1;
              sceneChange = true;
            break;
            
            //#endregion
        }
      }
    }

    }

    private void updatePositions(){
      P.updatePosition();

    }

    private void updateFrame() {
      //int x = (int)P.xpos;
      //int y = (int)P.ypos;
      //int w = P.getWidth();
      //int h = P.getHeight();

      gP.gimmeThatArrayList(sObjects);

      // gP.uGamePanel(x,y,w,h);
      gP.repaint();
    }

}
