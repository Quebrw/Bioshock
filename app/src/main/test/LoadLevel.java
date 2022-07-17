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
        this.addObject( 0, new worldObjects(20, 200, new Vector2f(900, 450), "box", 0));
        this.addObject( 0, new worldObjects(125, 200, new Vector2f(600, 300), "box", 0));
        this.addObject( 0, new worldObjects(10000, 50, new Vector2f(0, 0), "box", 0));
        this.addObject( 0, new worldObjects(400, 300, new Vector2f(1300, 300), "box", 0));
        this.addObject(0, new worldObjects(20, 50, new Vector2f(1200, 360), new Vector2f(1200, 700), "box", 0, new Vector2f(0, 3)));


        //World Loadboarders (copy paste)
        this.addObject( 0, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 0, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));
        //---------

        this.addStage();

        this.addObject( 1, new worldObjects(500, 300, new Vector2f(600, 400), "box", 0));
        this.addObject(1, new worldObjects(50, 50, new Vector2f(400, 300), new Vector2f(700, 300), "enemy", 20, new Vector2f(5, 0)));
        this.addObject(1, new worldObjects(50, 50, new Vector2f(750, 300), new Vector2f(1200, 300), "enemy", 20, new Vector2f(5, 0)));
        this.addObject( 1, new worldObjects(100, 300, new Vector2f(1300, 300), "box", 0));
        this.addObject( 1, new worldObjects(50, 150, new Vector2f(1600, 300), "trap", 0));


        //World Loadboarders (copy paste)
        this.addObject( 1, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 1, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));
    
        //---------

        this.addStage();

        this.addObject( 2, new worldObjects(70, 50, new Vector2f(200, 300), "box", 0));
        this.addObject( 2, new worldObjects(70, 50, new Vector2f(1000, 300), "box", 0));
        this.addObject( 2, new worldObjects(50, 750, new Vector2f(250, 300), "trap", 20));
        this.addObject( 2, new worldObjects(50, 750, new Vector2f(1050, 300), "trap", 20));
        this.addObject(2, new worldObjects(300, 20, new Vector2f(300, 450), new Vector2f(1800, 450), "box", 0, new Vector2f(8 , 0)));


        //World Loadboarders (copy paste)
        this.addObject( 2, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 2, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

        //---------

        this.addStage();  

        this.addObject( 3, new worldObjects(800, 50, new Vector2f(250, 370), "box", 0));
        this.addObject( 3, new worldObjects(800, 50, new Vector2f(1200, 370), "box", 0));
        this.addObject(3, new worldObjects(300, 900, new Vector2f(300, 300), new Vector2f(300, 700), "trap", 100, new Vector2f(0 , 5f)));

        this.addObject( 3, new worldObjects(75, 50, new Vector2f(1400, 300), "box", 0));
        this.addObject( 3, new worldObjects(175, 50, new Vector2f(1450, 300), "box", 0));
        this.addObject( 3, new worldObjects(250, 600, new Vector2f(1500, 300), "box", 0));


        //World Loadboarders (copy paste)
        this.addObject( 3, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 3, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));
        
        //---------

        this.addStage();

        this.addObject( 4, new worldObjects(250, 300, new Vector2f(0, 300), "box", 0));
        this.addObject( 4, new worldObjects(50, 1000, new Vector2f(300, 300), "trap", 20));
        this.addObject( 4, new worldObjects(250, 620, new Vector2f(1300, 300), "box", 0));
        this.addObject( 4, new worldObjects(200, 50, new Vector2f(450, 350), "box", 0));
        this.addObject( 4, new worldObjects(200, 50, new Vector2f(600, 350), "box", 0));
        this.addObject( 4, new worldObjects(200, 50, new Vector2f(750, 350), "box", 0));
        this.addObject( 4, new worldObjects(200, 50, new Vector2f(900, 350), "box", 0));
        this.addObject( 4, new worldObjects(200, 50, new Vector2f(1050, 350), "box", 0));
        this.addObject(4, new worldObjects(50, 50, new Vector2f(450, 550), new Vector2f(800, 550), "enemy", 20, new Vector2f(2 , 0)));
        this.addObject(4, new worldObjects(50, 50, new Vector2f(850, 550), new Vector2f(1200, 550), "enemy", 20, new Vector2f(2 , 0)));

        //World Loadboarders (copy paste)
        this.addObject( 4, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 4, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

        //---------

        this.addStage();

        this.addObject( 5, new worldObjects(250, 300, new Vector2f(0, 300), "box", 0));
        this.addObject( 5, new worldObjects(300, 100, new Vector2f(300, 300), "box", 0));
        this.addObject( 5, new worldObjects(300, 200, new Vector2f(1000, 300), "box", 0));
        this.addObject( 5, new worldObjects(300, 200, new Vector2f(1720, 300), "box", 0));

        this.addObject( 5, new worldObjects(50, 600, new Vector2f(400, 300), "trap", 20));
        this.addObject( 5, new worldObjects(50, 520, new Vector2f(1200, 300), "trap", 20));

        this.addObject( 5, new worldObjects(50, 50, new Vector2f(325, 650), "doubleJump", 0));

        //World Loadboarders (copy paste)
        this.addObject( 5, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 5, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

        //---------

        this.addStage();

        this.addObject( 6, new worldObjects(300, 200, new Vector2f(0, 300), "box", 0));
        this.addObject( 6, new worldObjects(1000, 50, new Vector2f(300, 400), "box", 0));
        this.addObject( 6, new worldObjects(200, 500, new Vector2f(800, 300), "box", 0));
        this.addObject(6, new worldObjects(50, 50, new Vector2f(301, 300), new Vector2f(749, 550), "enemy", 0, new Vector2f(4 , 0)));
        this.addObject(6, new worldObjects(50, 50, new Vector2f(1301, 300), new Vector2f(1920, 550), "enemy", 0, new Vector2f(4 , 0)));
        this.addObject(6, new worldObjects(50, 50, new Vector2f(800, 501), new Vector2f(1300, 501), "enemy", 0, new Vector2f(4 , 0)));


        //World Loadboarders (copy paste)
        this.addObject( 6, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 6, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

         //---------

        this.addStage();

        this.addObject(7, new worldObjects(250, 250, new Vector2f(320, 300), new Vector2f(1500, 450), "enemy", 20, new Vector2f(7 , 3)));
        this.addObject( 7, new worldObjects(200, 50, new Vector2f(300, 300), "box", 0));

        //World Loadboarders (copy paste)
        this.addObject( 7, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 7, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

        //---------

        this.addStage();

        //World Loadboarders (copy paste)
        this.addObject(8, new worldObjects(150, 50, new Vector2f(300, 350), new Vector2f(600, 500), "box", 20, new Vector2f(6, 4)));
        this.addObject( 8, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 8, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

        //---------

        this.addStage();
        this.addObject( 9, new worldObjects(1000, 50, new Vector2f(1870, 600), "box", 0));
        this.addObject( 9, new worldObjects(300, 50, new Vector2f(1870, 300), "Win", 0));



        //World Loadboarders (copy paste)
        this.addObject( 9, new worldObjects(10000, 50, new Vector2f(-60, 0), "leftTrigger", 0));
        this.addObject( 9, new worldObjects(10000, 50, new Vector2f(1920, 0), "rightTrigger", 0));

         //---------END

        
    };
    public void addStage(){
        level01.addStage();
    }

    public void addObject(int stageID, worldObjects object){
        level01.stages.get(stageID).addObject(object);
    }


}
