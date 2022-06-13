package objects;


import tools.Vector2f;

/**
 * worldObjects
 */
public class worldObjects {           //Every Object in the world should have a Position and Size; making this a Parent class simplifies passing the objects to the Collider      

    private float width;
    private float height;
    private Vector2f pos;

    //#region GetSet
    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Vector2f getPos() {
        return pos;
    }

    public worldObjects(){
        this.height = 0;
        this.pos = new Vector2f();
        this.width = 0;

    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
    }
    //#endregion
}
