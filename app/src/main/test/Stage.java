package test;

import java.util.ArrayList;
import tools.Vector2f;

import objects.worldObjects;

public class Stage {
    
    ArrayList<worldObjects> platforms = new ArrayList<worldObjects>(); 

    public Stage(worldObjects object){
        this.addObject(object);
    }
    public void addObject(worldObjects object){
        platforms.add(object);
    }
}
