package test;

import java.util.ArrayList;
import tools.Vector2f;

import objects.worldObjects;

public class Stage {
    
    ArrayList<worldObjects> platforms = new ArrayList<worldObjects>(); 

    public Stage(int h, int w, Vector2f p, String oT, int dmg){
        this.addObject(h, w, p, oT, dmg);
    };
    public void addObject(int h, int w, Vector2f p, String oT, int dmg){
        platforms.add(new worldObjects(h, w, p, oT, dmg));
    }
}
