package test;

import java.util.ArrayList;

import tools.Vector2f;

public class Level {
    
    ArrayList<Stage> stages = new ArrayList<Stage>();
    
    public Level(){
        
    };
    public void addStage(){
        stages.add(new Stage(50, 1920, new Vector2f(0,250), "box", 0));
    }
    
}
