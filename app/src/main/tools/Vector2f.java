package tools;

public class Vector2f {                         //2-Dimensional Vector, that contains a position in floats

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

    public Vector2f getDifference(Vector2f v2) {
        Vector2f tempV = new Vector2f();
        tempV.xpos = this.xpos - v2.xpos;
        tempV.ypos = this.ypos - v2.ypos;
        return tempV;
    }


    public void subtract(Vector2f v2, float basis){
        //System.out.println(this.xpos);
        this.xpos = this.xpos - (v2.xpos * basis);
        //System.out.println(this.xpos);
        this.ypos = this.ypos - (v2.ypos * basis);
    }

    //void loop(){}
}
