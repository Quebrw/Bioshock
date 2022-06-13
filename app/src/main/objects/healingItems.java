package objects;
//import src.tools.*;

// Generates healing potion/pad which extends 
public class healingItems extends Items{
int healing = 30;

    public void addHealth(player p){

        if ((p.health + healing) <= 100){
            p.health += healing;
        } else {
            p.health = 100;
        }
    }
}
