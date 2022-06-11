package src;
import src.tools.*;

public abstract class Items {

    Vector2f pos = new Vector2f();

    public Items(){
        this.pos.setXpos(0.0f);

    }
}

public class healingItems extends Items{
    int healing;

}
