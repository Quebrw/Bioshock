package tools;
import objects.*;
import java.util.ArrayList;

public class Collider {                                             //Class that handles Collisions
    
    public static boolean isColliding(worldObjects o1, worldObjects o2) {            //Function that checks if two Objects are Colliding
        /* 
        if(((o1.getPos().getXpos() + o1.getWidth()) > o2.getPos().getXpos() && o1.getPos().getXpos() < (o2.getPos().getXpos() + o2.getWidth())) || ((o2.getPos().getXpos() + o2.getWidth()) > o1.getPos().getXpos() && o2.getPos().getXpos() < (o1.getPos().getXpos() + o1.getWidth()))){   //checks horizontal Collision
            System.out.println("yes");
            if(((o1.getPos().getYpos() + o1.getHeight()) > o2.getPos().getYpos() && o1.getPos().getYpos() < (o2.getPos().getYpos() + o2.getHeight())) || ((o2.getPos().getYpos() + o2.getHeight()) > o1.getPos().getYpos() && o2.getPos().getYpos() < (o1.getPos().getYpos() + o1.getHeight()))){   //checks vertical Collision
                System.out.println("yes2");
                return true;
            }else{
                System.out.println("no2");
                return false;
            }   
        }else{
            System.out.println("no");
            return false;
        }
        */
        System.out.println(o1.xpos +" playpos | " + o2.xpos + " objpos | " + (o1.xpos+o1.getWidth()) + " playcorner | " + (o2.xpos+o2.getWidth()) + " objcorner");
        if((o1.despos.getXpos() <= o2.xpos && o2.xpos <= (o1.despos.getXpos() + o1.getWidth()) ) || (o2.xpos <= o1.despos.getXpos() && o1.despos.getXpos() <= (o2.xpos + o2.getWidth()) )){
            if((o1.despos.getYpos() <= o2.ypos && o2.ypos <= (o1.despos.getYpos() + o1.getHeight()) ) || (o2.ypos <= o1.despos.getYpos() && o1.despos.getYpos() <= (o2.ypos + o2.getHeight()) )){
                System.out.println("yes");
                return true;
            }else{
                System.out.println("no2");
                return false;
            }
        }else{
            
            return false;
        }

    }

    public static ArrayList<worldObjects> getCollisisions(worldObjects collider, ArrayList<worldObjects> sceneObjects) {                    //since further Collision computing with objects that are not colliding is unnecessary, this function will filter out non-Colliding Objects
        ArrayList<worldObjects> output = new ArrayList<worldObjects>(0);
        for (int i = 0; i < sceneObjects.size(); i++) {
                worldObjects tempO = (worldObjects) sceneObjects.get(i);
            if(isColliding(collider, tempO) == true && collider != tempO){
                output.add(tempO);
            }
        }
        return output;
    }
}
