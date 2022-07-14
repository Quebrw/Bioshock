package test;

import tools.Vector2f;
//import objects.worldObjects;

public class LoadLevel {
    
    Level level01 = new Level();

    public LoadLevel(){

        this.addStage();

        this.addObject(0, 20, 300, new Vector2f(900, 450), "box", 0);
        this.addObject(0, 300, 200, new Vector2f(600, 100), "box", 0);
        this.addObject(0, 10000, 50, new Vector2f(0, 0), "box", 0);

        //World Loadboarders (copy paste)
        this.addObject(0, 10000, 50, new Vector2f(-60, 0), "leftTrigger", 0);
        this.addObject(0, 10000, 50, new Vector2f(1920, 0), "rightTrigger", 0);

        //---------

        this.addStage();

        this.addObject(1, 20, 300, new Vector2f(600, 400),"box", 0);
        this.addObject(1, 50, 50, new Vector2f(400,300),"trap", 20);
        this.addObject(1, 50, 50, new Vector2f(700,420),"trap", 20);

        
        //World Loadboarders (copy paste)
        this.addObject(1, 10000, 50, new Vector2f(-60, 0), "leftTrigger", 0);
        this.addObject(1, 10000, 50, new Vector2f(1920, 0), "rightTrigger", 0);

        //---------

        this.addStage();

        this.addObject(2, 70, 50, new Vector2f(200, 300), "box", 0);
        this.addObject(2, 70, 50, new Vector2f(1000, 300), "box", 0);
        this.addObject(2, 50, 750, new Vector2f(250,300),"trap", 20);


        //World Loadboarders (copy paste)
        this.addObject(2, 10000, 50, new Vector2f(-60, 0), "leftTrigger", 0);
        this.addObject(2, 10000, 50, new Vector2f(1920, 0), "rightTrigger", 0);

        //---------

        this.addStage();  


        //World Loadboarders (copy paste)
        this.addObject(2, 10000, 50, new Vector2f(-60, 0), "leftTrigger", 0);
        this.addObject(2, 10000, 50, new Vector2f(1920, 0), "rightTrigger", 0);
        
    };
    public void addStage(){
        level01.addStage();
    }

    public void addObject(int stageID, int h, int w, Vector2f p, String oT, int dmg){
        level01.stages.get(stageID).addObject(h, w, p, oT, dmg);
    }


}
