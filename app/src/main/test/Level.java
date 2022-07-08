package test;

import java.util.ArrayList;

import tools.Vector2f;

public class Level {
    
    ArrayList<Stage> stages = new ArrayList<Stage>();
    public Level(){
        
    };
    public void addStage(){
        stages.add(new Stage(20, 300, new Vector2f(100, 100), "box", 0));
    }
    
}
