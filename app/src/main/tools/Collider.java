package tools;
import objects.*;

public class Collider {                                             //Class that handles Collisions
    
    public static boolean isColliding(worldObjects o1, worldObjects o2) {            //Function that checks if two Objects are Colliding
        if(((o1.getPos().getXpos() + o1.getWidth()) > o2.getPos().getXpos() && o1.getPos().getXpos() < (o2.getPos().getXpos() + o2.getWidth())) || ((o2.getPos().getXpos() + o2.getWidth()) > o1.getPos().getXpos() && o2.getPos().getXpos() < (o1.getPos().getXpos() + o1.getWidth()))){   //checks horizontal Collision
            if(((o1.getPos().getYpos() + o1.getHeight()) > o2.getPos().getYpos() && o1.getPos().getYpos() < (o2.getPos().getYpos() + o2.getHeight())) || ((o2.getPos().getYpos() + o2.getHeight()) > o1.getPos().getYpos() && o2.getPos().getYpos() < (o1.getPos().getYpos() + o1.getHeight()))){   //checks vertical Collision
                return true;
            }else{
                return false;
            }   
        }else{
            return false;
        }

    }
}
