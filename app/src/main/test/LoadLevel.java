package test;

import objects.worldObjects;
import tools.Vector2f;
//import objects.worldObjects;

public class LoadLevel {
    
    Level level01 = new Level();

    public LoadLevel(){

        //adds new Stage, in which you are able to place world objects
        this.addStage();

        this.addObject( 0, new worldObjects(50, 50, new Vector2f(300, 300), "box", 0));
        this.addObject( 0, new worldObjects(20, 250, new Vector2f(900, 450), "box", 0));
        this.addObject( 0, new worldObjects(125, 200, new Vector2f(600, 300), "box", 0));
        this.addObject( 0, new worldObjects(10000, 50, new Vector2f(0, 0), "box", 0));
        this.addObject( 0, new worldObjects(400, 300, new Vector2f(1300, 300), "box", 0));
        this.addObject(0, new worldObjects(20, 50, new Vector2f(1225, 300), new Vector2f(1600, 700), "box", 0, new Vector2f(0, 3)));

        //this.addObject( 0, new worldObjects(50, 50, new Vector2f(300, 400), "doubleJump", 0));

        //World Loadboarders (copy paste)
        this.addObject( 0, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 0, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));
        //---------

        this.addStage();

        this.addObject( 1, new worldObjects(500, 300, new Vector2f(600, 400), "box", 0));
        this.addObject(1, new worldObjects(50, 50, new Vector2f(400, 300), new Vector2f(700, 300), "trap", 20, new Vector2f(5, 0)));
        this.addObject(1, new worldObjects(50, 50, new Vector2f(750, 300), new Vector2f(1200, 300), "trap", 20, new Vector2f(5, 0)));
        this.addObject( 1, new worldObjects(100, 300, new Vector2f(1300, 300), "box", 0));
        this.addObject( 1, new worldObjects(50, 150, new Vector2f(1600, 300), "trap", 20));


        


        //World Loadboarders (copy paste)
        this.addObject( 1, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 1, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));
        

        //---------

        this.addStage();

        this.addObject( 2, new worldObjects(70, 50, new Vector2f(200, 300), "box", 0));
        this.addObject( 2, new worldObjects(70, 50, new Vector2f(1000, 300), "box", 0));
        this.addObject( 2, new worldObjects(50, 750, new Vector2f(250, 300), "trap", 0));
        this.addObject( 2, new worldObjects(50, 750, new Vector2f(1050, 300), "trap", 0));



        this.addObject(2, new worldObjects(300, 20, new Vector2f(300, 450), new Vector2f(1800, 450), "box", 0, new Vector2f(5 , 0)));


        //World Loadboarders (copy paste)
        this.addObject( 2, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 2, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

        //---------

        this.addStage();  


        //World Loadboarders (copy paste)
        this.addObject( 3, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 3, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));
        
    };
    public void addStage(){
        level01.addStage();
    }

    public void addObject(int stageID, worldObjects object){
        level01.stages.get(stageID).addObject(object);
    }


}
