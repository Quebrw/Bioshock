package objects;
import tools.Vector2f;

public abstract class Items {

    Vector2f pos = new Vector2f();

    public Items(){
        this.pos.setXpos(0.0f);
        this.pos.setYpos(0.0f);
    }
}
