package test;

import tools.Vector2f;
//import objects.worldObjects;

public class LoadLevel {
    
    Level level01 = new Level();

    public LoadLevel(){

        this.addStage();
        this.addObject(0, 20, 300, new Vector2f(200, 375), "box", 0);
        this.addObject(0, 20, 200, new Vector2f(600, 425), "box", 0);
        this.addObject(0, 10000, 50, new Vector2f(-55, 0), "box", 0);

        //World Loadboarders (copy paste)
        this.addObject(0, 10000, 50, new Vector2f(-60, 0), "leftTrigger", 0);
        this.addObject(0, 10000, 50, new Vector2f(1920, 0), "rightTrigger", 0);


        this.addStage();
        this.addObject(1, 10, 500, new Vector2f(100, 100), "box", 0);
        this.addObject(1, 20, 300, new Vector2f(600, 425),"box", 0);
        this.addObject(1, 50, 50, new Vector2f(400,400),"trap", 100);

        //World Loadboarders (copy paste)
        this.addObject(1, 10000, 50, new Vector2f(-60, 0), "leftTrigger", 0);
        this.addObject(1, 10000, 50, new Vector2f(1920, 0), "rightTrigger", 0);


        this.addStage();
        this.addObject(2, 500, 300, new Vector2f(600, 300), "box", 0);
        this.addObject(2, 500, 300, new Vector2f(1100, 300), "box", 0);
        this.addObject(2, 50, 200, new Vector2f(1300, 600), "box", 0);


        this.addStage();  
        
    };
    public void addStage(){
        level01.addStage();
    }

    public void addObject(int stageID, int h, int w, Vector2f p, String oT, int dmg){
        level01.stages.get(stageID).addObject(h, w, p, oT, dmg);
    }


}
