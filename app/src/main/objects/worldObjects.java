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
    public boolean movingx, movingy , hascollided;
    private Vector2f moveFrom, moveTo = new Vector2f(0,0);
    public String movDirx, movDiry;
    private int speedx, speedy = 0;

    public worldObjects(){
        this.height = 0;
        this.pos = new Vector2f();
        this.width = 0;
        this.ObjectType = "generic";
        this.damage = 0;
        this.movingx = false;
        this.movingy = false;

        this.hascollided = false;
    }

    public worldObjects(int h, int w, Vector2f p, String oT, int dmg) {
        this.height = h;
        this.width = w;
        this.pos = p;
        this.ObjectType = oT;
        this.xpos = this.pos.getXpos();
        this.ypos = this.pos.getYpos();
        this.damage = dmg;
        this.movingx = false;
        this.movingy = false;

        this.hascollided = false;

    }

    public worldObjects(int h, int w,  Vector2f moveF, Vector2f moveT, String oT, int dmg, Vector2f speed) {
        this.height = h;
        this.width = w;
        this.pos = moveF;
        this.ObjectType = oT;
        this.xpos = this.pos.getXpos();
        this.ypos = this.pos.getYpos();
        this.damage = dmg;

        if(moveF.getXpos() - moveT.getXpos() != 0){
            movingx = true;
            speedx = Math.abs((int)speed.getXpos());
        }else{
            movingx =false;
        }
        if(moveF.getYpos() - moveT.getYpos() != 0){
            movingy = true;
            speedy = Math.abs((int)speed.getYpos());
        }else{
            movingy = false;
        }
        this.moveFrom = moveF;
        this.moveTo = moveT;        
        this.hascollided = false;

    }

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

    public float moveFx() {
        if(this.movingx == true){
            return moveFrom.getXpos();
        }else{
            //System.err.println("Should not be Moving X");
            return 0f;
        }
    }

    public float moveTx() {
        if(this.movingx == true){
            return moveTo.getXpos();
        }else{
            //System.err.println("Should not be Moving X");
            return 0f;
        }
    }

    public float moveFy() {
        if(this.movingy == true){
            return moveFrom.getYpos();
        }else{
            //System.err.println("Should not be Moving Y");
            return 0f;
        }
    }

    public float moveTy() {
        if(this.movingy == true){
            return moveTo.getYpos();
        }else{
            //System.err.println("Should not be Moving Y");
            return 0f;
        }
    }

    public int Speedx(){
        return speedx;
    }

    public int Speedy() {
        return speedy;
    }

    public void setFromTo(Vector2f from, Vector2f to){
        this.moveFrom = from;
        this.moveTo = to;
    }

    public void setSx(int speed){
        this.speedx = speed;
    }

    public void setSy(int speed){
        this.speedy = speed;
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
