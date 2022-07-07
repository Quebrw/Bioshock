package objects;


import tools.Vector2f;

/**
 * worldObjects
 */
public class worldObjects {           //Every Object in the world should have a Position and Size; making this a Parent class simplifies passing the objects to the Collider      

    public int width,  height, damage;
    private Vector2f pos;
    public float xpos, ypos;
    private String ObjectType;
    public Vector2f despos;

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
        this.damage = 0;
    }

    public worldObjects(int h, int w, Vector2f p, String oT, int dmg) {
        this.height = h;
        this.width = w;
        this.pos = p;
        this.ObjectType = oT;
        this.xpos = this.pos.getXpos();
        this.ypos = this.pos.getYpos();
        this.damage = dmg;
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
