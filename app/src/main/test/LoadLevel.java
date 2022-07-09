package test;

import tools.Vector2f;
//import objects.worldObjects;

public class LoadLevel {
    
    Level level01 = new Level();

    public LoadLevel(){

        this.addStage();
        this.addObject(0, 20, 300, new Vector2f(200, 375), "box", 0);

        /*
        worldObjects box = new worldObjects(100,1500, new Vector2f(200.0f,200.0f), "box", 0);
        worldObjects box2 = new worldObjects(100,3000, new Vector2f(-100.0f, 0.0f), "box", 0);
        worldObjects box3 = new worldObjects(50 ,50, new Vector2f(1000, 300.0f), "trap", 20); 
        this.addObject(0, 0, 200, new Vector2f(100, 100), "box", 0);
        this.addObject(0, 0, 200, new Vector2f(400, 400), "box", 0);
         */

        this.addStage();
        this.addObject(1, 10, 500, new Vector2f(100, 100), "generic", 0);

    };
    public void addStage(){
        level01.addStage();
    }

    public void addObject(int stageID, int h, int w, Vector2f p, String oT, int dmg){
        level01.stages.get(stageID).addObject(h, w, p, oT, dmg);
    }


}
