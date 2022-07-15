package test;
import java.util.ArrayList;

import objects.Player;
import objects.worldObjects;
import tools.Collider;
import tools.MyKeyHandler;
import tools.Vector2f;
import objects_graphics.*;
//import java.awt.Component;
import javax.swing.*;   
//import java.awt.Graphics;  
//Maybe specify later

//import java.awt.Graphics2D;

import test.Gamestate;
import GUI.GamePanel;
import GUI.Menu;
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
  private int Stagecounter;

  
  //______SPECIFIC_ENTITIES_____
  private worldObjects refGround = new worldObjects();
  
  //_______PLAYER_______________
  public Player P = new Player();
  private boolean running = true;
  private boolean inertiaR, inertiaL, extraJump, dJumpenabled;
  private long stoppedMovingR, stoppedMovingL;
  private long beganMoving, beganJump;
  private int jumpFrames, invincFrames, dJumpCoold, slamCoold;
  private float slamHeight;
  public boolean isSlamming;
  public int shiftFrameC, spaceFrameC = 0;

  private int counter;
  




    //#endregion

    public GameLoop(MyKeyHandler kHin, GamePanel gamePanel) {
      this.kH = kHin;
      this.gP = gamePanel;
    }


    @Override
    public void run() {
      invincFrames = 0;
      extraJump = false;
      dJumpCoold = 0;
      dJumpenabled = false;


      P.setHeight(50);                   
      P.setWidth(50);
      P.xpos = 500f;
      P.ypos = 500f;
      P.health = 40;
      P.despos.setXpos(P.xpos);
      P.despos.setYpos(P.ypos); 

      
  

      LoadLevel test = new LoadLevel();
      
      
      refGround.setObjectType("generic");
      refGround.xpos = -100.0f;
      refGround.width = 3000;
      refGround.ypos = -100f;
      refGround.height = 1; 

      sObjects.clear();
      sObjects.add(P);


    
      for(int i = 0; i < test.level01.stages.get(Stagecounter).platforms.size(); i++){
        sObjects.add(test.level01.stages.get(Stagecounter).platforms.get(i));
      }





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

        if (gP.gameState == gP.gameStatePlaying) {

          updatePlayerMovement();
          
          updateScene();

          updateCollision();

          updateObjectMovement();

          updaterefGroundMovement();
          
          //Handles a bug where the player floats above the ground and behaves as if he's still touching it
          if(P.touchingGround && true && P.despos.getYpos() != (refGround.ypos + refGround.height + 1)){
            P.despos.setYpos((refGround.ypos + refGround.height + 1));
          }

          updatePositions();

        } 
        else if (gP.gameState == gP.gameStateMenu) {

        }

      gameState();
    
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

        //Counter so the player doesnt just hold down Space or shift
      if(kH.SHIFT_PRESSED == true){
        shiftFrameC +=1;
      }else{
        shiftFrameC = 0;
      }
      if(kH.SPACE_PRESSED == true){
        spaceFrameC += 1;
      }else{
        spaceFrameC = 0;
      }

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
        if(kH.SPACE_PRESSED == true && (P.touchingGround == true || ((jumpFrames > 0 && jumpFrames < 8) && (P.actMovL == true || P.actMovR == true) && spaceFrameC < 2) || (extraJump == true && dJumpCoold == 0 && dJumpenabled == true) )){
          if(extraJump == false && P.touchingGround == true){
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
        if(kH.SHIFT_PRESSED == true && P.touchingGround == false && slamCoold == 0 && shiftFrameC < 2){
          isSlamming = true;
          slamCoold = 20;
          slamHeight = P.ypos;

          // for sprite Groundslam animation
          P.isSlamming = true;
        }
        if(isSlamming == true){
          P.despos = new Vector2f(P.xpos, (P.ypos - 20f)); 
        }
        gP.getSpace(kH);
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

      //hascollided is only valid for one frame
      for (worldObjects i : sObjects) {
        i.hascollided = false;
      }
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
              //important for if a moving object collides with the player this Frame
              int index = sObjects.indexOf(colliders.get(j));
              sObjects.get(index).hascollided = true;
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

                // cancels Groundslam animation

                P.isSlamming = false;

                P.despos.setYpos(colliders.get(j).ypos + colliders.get(j).height +1);
                isSlamming = false;
                //there are 2 ways a player can leave a surface: per jumping or per stepping off the platform. To account for the second one a copy of the current surface's x-Dimensions is made for reference
                //yes, inefficient, i know i shouldve just created a new object but this works too
                refGround.xpos = colliders.get(j).xpos;
                refGround.width = colliders.get(j).width;
                refGround.ypos = colliders.get(j).ypos;
                refGround.height = colliders.get(j).height;
                //if the Object is moving, the reference Ground has to move with it
                refGround.movDirx = colliders.get(j).movDirx;
                refGround.movDiry = colliders.get(j).movDiry;
                refGround.movingx = colliders.get(j).movingx;
                refGround.movingy = colliders.get(j).movingy;
                refGround.setSx(colliders.get(j).Speedx());
                refGround.setSy(colliders.get(j).Speedy());
                refGround.setFromTo(new Vector2f(colliders.get(j).moveFx(), colliders.get(j).moveFy()), new Vector2f(colliders.get(j).moveTx(), colliders.get(j).moveTy()));
                

              }
              //allows Walljump & makes it so touching an overhead surface ends a jump
              if(colliders.get(j).ypos > (P.ypos + P.height) && ((P.xpos >= colliders.get(j).xpos && P.xpos <= (colliders.get(j).xpos + colliders.get(j).width))||((P.xpos + P.width) >= colliders.get(j).xpos && (P.xpos + P.width) <= (colliders.get(j).xpos + colliders.get(j).width)))){
                beganJump = System.nanoTime() - ((2* P.jumpLenght)/3);
                
                // is used for wall climbing
                P.spriteWall = false;
              }else{
                if(P.touchingGround == false){
                  jumpFrames = 10;
                  beganJump = System.nanoTime() - ((2* P.jumpLenght)/3);

                  // is used for wall climbing
                  P.spriteWall = true;

                }
              }

            break;

            case "doubleJump":
              dJumpenabled = true;
            break;

            case "trap":
            //if the player groundslams right above the Trap (currently 50px) he will avoid damage and bounce off the trap
              if((P.ypos > (colliders.get(j).ypos + colliders.get(j).height) && ((P.xpos >= colliders.get(j).xpos && P.xpos <= (colliders.get(j).xpos + colliders.get(j).width))||((P.xpos + P.width) >= colliders.get(j).xpos && (P.xpos + P.width) <= (colliders.get(j).xpos + colliders.get(j).width)))) && isSlamming == true && (slamHeight - P.ypos) <= 55){
                isSlamming = false;
                P.isSlamming = false;
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

            //some traps should not be "avoidable" with a groundslam
            case "trapPlus":
            if(invincFrames == 0){
              P.ouch(colliders.get(j).damage);
              invincFrames = 90;

            }
            break;
            //#region SceneTriggers

            
            case "rightTrigger":
              Stagecounter++;
              // worldGrid[0] += 1;
              P.despos.setXpos(0);
              sceneChange = true;
            break;

            case "leftTrigger":
              Stagecounter--;
              // worldGrid[0] -= 1;
              P.despos.setXpos(1850);
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
  
    private void updateObjectMovement(){
      for (worldObjects o : sObjects) {
        if(o.movingx == true){
          //basic 2-state machine
          if(o.xpos <= o.moveFx()){
            o.movDirx = "right";
          }else if(o.xpos >= o.moveTx()){
            o.movDirx = "left";
          }
          //switch because I like them better than "if"s
          switch(o.movDirx){
            case "right":
              o.xpos += o.Speedx();
              if(o.hascollided == true){
                P.despos.setXpos(P.despos.getXpos() + o.Speedx());
              }
            break;

            case "left":
              o.xpos -= o.Speedx();
              if(o.hascollided == true){
                P.despos.setXpos(P.despos.getXpos() - o.Speedx());
              }            
            break;
          }
        }

        if(o.movingy ==  true){
          if(o.ypos <= o.moveFy()){
            o.movDiry = "up";
          }else if(o.ypos >= o.moveTy()){
            o.movDiry = "down";
          }

          switch(o.movDiry){
            case "up":
              o.ypos += o.Speedy();
              if(o.hascollided == true){
                P.despos.setYpos(P.despos.getYpos() + o.Speedy());
              }
            break;

            case "down":
              o.ypos -= o.Speedy();
              if(o.hascollided == true){
                P.despos.setYpos(P.despos.getYpos() - o.Speedy());
              }            
            break;
          }
        }

      }
    }

    //this is solely used for updating the reference Object 
    private void updaterefGroundMovement(){
      worldObjects o = refGround;
      if(o.movingx == true){
          //basic 2-state machine
          if(o.xpos <= o.moveFx()){
            o.movDirx = "right";
          }else if(o.xpos >= o.moveTx()){
            o.movDirx = "left";
          }
          //switch because I like them better than "if"s
          switch(o.movDirx){
            case "right":
              o.xpos += o.Speedx();

            break;

            case "left":
              o.xpos -= o.Speedx();
    
            break;
          }
        }

        if(o.movingy ==  true){
          if(o.ypos <= o.moveFy()){
            o.movDiry = "up";
          }else if(o.ypos >= o.moveTy()){
            o.movDiry = "down";
          }

          switch(o.movDiry){
            case "up":
              o.ypos += o.Speedy();

            break;

            case "down":
              o.ypos -= o.Speedy();
          
            break;
          }
        }

        refGround = o;

      
    }

    private void updatePositions(){
      P.updatePosition();

    }

    public void loadnewScene() {
      // Stagecounter soll sich erhöhen sobald trigger passiert wurde, lädt dann neue Stage
      // TODO
      sObjects.clear();
      sObjects.add(P);
      
      LoadLevel test = new LoadLevel();

      for(int i = 0; i < test.level01.stages.get(Stagecounter).platforms.size(); i++){
        sObjects.add(test.level01.stages.get(Stagecounter).platforms.get(i));
      }
    }
    
    private void updateFrame() {

      gP.gimmeThatArrayList(sObjects);

      gP.repaint();
    }
    public void gameState() {
      
       // for the gamestate 
       if (kH.ESCAPE_PRESSED == true) {
        if (counter > 0) {

          counter --;


        } else {

        if (gP.gameState == gP.gameStatePlaying) {

          gP.gameState = gP.gameStateMenu;

        } else if (gP.gameState == gP.gameStateMenu) {

          gP.gameState = gP.gameStatePlaying;
        }

        counter = 10;

        }
      }
    }
}
