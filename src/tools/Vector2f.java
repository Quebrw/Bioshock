package src.tools;

public class Vector2f {

    private float xpos;
    private float ypos; 

    public Vector2f(){
        this.xpos = 0f;
        this.ypos = 0f;
    }

    public Vector2f(float xpos, float ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public float getXpos() {
        return xpos;
    }

    public float getYpos() {
        return ypos;
    }

    public void setXpos(float xpos) {
        this.xpos = xpos;
    }

    public void setYpos(float ypos) {
        this.ypos = ypos;
    }

    public float[] getVector2f(){
        return new float[]{this.xpos, this.ypos};
    }

}
