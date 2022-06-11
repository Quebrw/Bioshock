package src.objects;
import src.tools.*;

// Generates healing potion/pad
public class healingItems extends Items{
int healing = 30;

    public void addHealth(player p){

        if ((player.health + healing) =< 100){
            player.health += healing;
        } else {
            player.health = 100;
        }
    }
}
