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
  //private float lastUpdate;
  private float updateRate = (1.0f/60.0f) * 1000.0f;
  
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
  private boolean inertiaR, inertiaL, extraJump, dJumpenabled, isSlamming;
  private long stoppedMovingR, stoppedMovingL;
  private long beganMoving, beganJump;
  private int jumpFrames, invincFrames, dJumpCoold, slamCoold;
  private float slamHeight;


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
      P.health = 40;
      P.despos.setXpos(P.xpos);
      P.despos.setYpos(P.ypos); 
      worldObjects box = new worldObjects(100,1500, new Vector2f(200.0f,200.0f), "box", 0);
      worldObjects box2 = new worldObjects(100,3000, new Vector2f(-100.0f, 0.0f), "box", 0);
      worldObjects box3 = new worldObjects(50 ,50, new Vector2f(1000, 300.0f), "trap", 20);
      invincFrames = 0;

      //switchCoold = 180;
      
      
      refGround.setObjectType("generic");
      refGround.xpos = -100.0f;
      refGround.width = 3000;
      refGround.ypos = -100f;
      refGround.height = 1; 

      sObjects.clear();
      sObjects.add(P);
      sObjects.add(box);
      sObjects.add(box2);
      sObjects.add(box3);
      extraJump = false;
      dJumpCoold = 0;
      dJumpenabled = false;
      //Fuck that Problem-text
      if(sceneChange == true){

      }
      System.out.println(sObjects.size());
      //This Loop calls the update Function every 1/60th of a second
      while (running == true) {

        update(System.nanoTime());
        try {
          Thread.sleep((long) updateRate);
        } catch (Exception e) {
          System.err.println("no Thread");
        }
        
    
            
      }
    }

    //-------------------------------------------------------------------------------------------------------------------------------
    //General update method; streamlines and organises specific updates; takes in time at which the update is called for convienience
    //-------------------------------------------------------------------------------------------------------------------------------
    public void update(float time){


      if(sceneChange == false){
      updatePlayerMovement();
      
      updateScene();

      updateCollision();

      //Handles a bug where the player floats above the ground and behaves as if he's still touching it
      if(P.touchingGround && true && P.despos.getYpos() != (refGround.ypos + refGround.height + 1)){
        P.despos.setYpos((refGround.ypos + refGround.height + 1));
      }

      updatePositions();
      
      updateFrame();

      if(dJumpCoold > 0){
        dJumpCoold -= 1;
      }
      if(slamCoold > 0){
        slamCoold -= 1;
      }
      if(jumpFrames > 0){
        jumpFrames = jumpFrames - 1;
        }

    }else{
      loadnewScene();
      sceneChange = false;
    }
    }

    private void updatePlayerMovement() {

        //------------------------------------------------------------------------------------------------------------------------------------------------
        //The Player starts sprinting after 2 seconds, when stopping to sprint, they will experience a certiant inertia of movement because of their speed
        //------------------------------------------------------------------------------------------------------------------------------------------------

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
        if(kH.SPACE_PRESSED == true && (P.touchingGround == true || ((jumpFrames > 0 && jumpFrames < 5) && (P.actMovL == true || P.actMovR == true)) || (extraJump == true && dJumpCoold == 0 && dJumpenabled == true) )){
          if(extraJump == false){
            extraJump = true;
            dJumpCoold = 30;
            slamCoold = 20;
          }else{
            extraJump = false;
          }
          beganJump = System.nanoTime();
          P.touchingGround = false;
          jumpFrames = 0;
        }

        //executes the jump
        if((System.nanoTime() - beganJump) < P.jumpLenght){
          P.jump(System.nanoTime() - beganJump);
        }
        
        //checks if the player has stepped off a platform and should therefore experience gravity
        if(((P.xpos + P.width) < refGround.xpos || P.xpos > (refGround.xpos + refGround.width)) && P.touchingGround == true){
          P.touchingGround = false;
          beganJump = System.nanoTime() - ((2* P.jumpLenght)/3);
        }

        //----------------------
        //Handles the Groundslam
        //----------------------
        if(kH.SHIFT_PRESSED == true && P.touchingGround == false && slamCoold == 0){
          isSlamming = true;
          slamCoold = 20;
          slamHeight = P.ypos;
        }
        if(isSlamming == true){
          P.despos = new Vector2f(P.xpos, (P.ypos - 20f)); 
        }

    }

    //may be unnecessary
    private void updateScene() {
      sObjects.set(0, P);
    }

    private void updateCollision() {  //currently only checking Player collision
      if(invincFrames > 0){
        invincFrames -= 1;
      }
      //gets a List of all Objects that are currently touching the player
      ArrayList<worldObjects> colliders = Collider.getCollisisions(P, sObjects);
      //System.out.println(colliders + "|" + colliders.size()); //debug
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
              //P.pos.setXpos(P.xpos);
              //P.pos.setYpos(P.ypos);
              Vector2f move = P.despos.getDifference(new Vector2f(P.xpos, P.ypos));
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
                P.despos.setYpos(colliders.get(j).ypos + colliders.get(j).height +1);
                isSlamming = false;
                //there are 2 ways a player can leave a surface: per jumping or per stepping off the platform. To account for the second one a copy of the current surface's x-Dimensions is made for reference
                refGround.xpos = colliders.get(j).xpos;
                refGround.width = colliders.get(j).width;
                refGround.ypos = colliders.get(j).ypos;
                refGround.height = colliders.get(j).height;
              }
              //allows Walljump & makes it so touching an overhead surface ends a jump
              if(colliders.get(j).ypos > (P.ypos + P.height) && ((P.xpos >= colliders.get(j).xpos && P.xpos <= (colliders.get(j).xpos + colliders.get(j).width))||((P.xpos + P.width) >= colliders.get(j).xpos && (P.xpos + P.width) <= (colliders.get(j).xpos + colliders.get(j).width)))){
                beganJump = System.nanoTime() - ((2* P.jumpLenght)/3);
              }else{
                if(P.touchingGround == false){
                  jumpFrames = 6;
                  beganJump = System.nanoTime() - ((2* P.jumpLenght)/3);

                }
              }

            break;

            case "trap":
            //if the Player Groundslams right above the Trap (currently 50px) he will avoid damage and bounce off the trap
              if((P.ypos > (colliders.get(j).ypos + colliders.get(j).height) && ((P.xpos >= colliders.get(j).xpos && P.xpos <= (colliders.get(j).xpos + colliders.get(j).width))||((P.xpos + P.width) >= colliders.get(j).xpos && (P.xpos + P.width) <= (colliders.get(j).xpos + colliders.get(j).width)))) && isSlamming == true && (slamHeight - P.ypos) <= 55){
                isSlamming = false;
                slamCoold = 20;
                beganJump = System.nanoTime() - ((System.nanoTime()-beganJump)/5);
                P.despos = new Vector2f(P.xpos, colliders.get(j).ypos + colliders.get(j).height +1 );

              }else{
                //otherwise he takes damage and briefly becomes invincible
                if(invincFrames == 0){
                  P.ouch(colliders.get(j).damage);
                  invincFrames = 90;
                }
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
      gP.getShit(invincFrames, P);
    }

    private void updatePositions(){
      P.updatePosition();

    }

    public void loadnewScene() {
      
    }
    
    private void updateFrame() {

      gP.gimmeThatArrayList(sObjects);

      gP.repaint();
    }

}
