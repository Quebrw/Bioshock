package tools;

public class Vector2f {                         //2-Dimensional Vector, that contains a position inf floats

    private float xpos;
    private float ypos; 

    public Vector2f(){                          // Nullconstructor
        this.xpos = 0f;
        this.ypos = 0f;
    }

    public Vector2f(float xpos, float ypos){    //Constructor
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

    public void increaseX(float increaseBy, boolean positive) {
        
        if(positive == true){
            this.xpos += increaseBy;
        }else{
            this.xpos -= increaseBy;
        }
    }

    public void increaseY(float increaseBy, boolean positive) {
        
        if(positive == true){
            this.ypos += increaseBy;
        }else{
            this.ypos -= increaseBy;
        }
    }


    void loop(){}
}