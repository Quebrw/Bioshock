package objects;


import tools.Vector2f;

/**
 * worldObjects
 */
public class worldObjects {           //Every Object in the world should have a Position and Size; making this a Parent class simplifies passing the objects to the Collider      

    private int width;
    private int height;
    private Vector2f pos;
    private String ObjectType;

    //#region GetSet
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Vector2f getPos() {
        return pos;
    }

    public String getObjectType() {
        return ObjectType;
    }

    public worldObjects(){
        this.height = 0;
        this.pos = new Vector2f();
        this.width = 0;
        this.ObjectType = "generic";
    }

    public worldObjects(int h, int w, Vector2f p, String oT) {
        this.height = h;
        this.width = w;
        this.pos = p;
        this.ObjectType = oT;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
    }

    public void setObjectType(String objectType) {
        ObjectType = objectType;
    }
    //#endregion
}
