package test;

import java.util.ArrayList;

import objects.worldObjects;
import tools.Vector2f;

public class Level {
    
    ArrayList<Stage> stages = new ArrayList<Stage>();
    
    public Level(){
        
    };
    public void addStage(){
        //Ground that is added with every Stage
       stages.add(new Stage(new worldObjects(50, 1920, new Vector2f(0,250), "box", 0)));
    }
    
}
