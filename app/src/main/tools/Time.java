package tools;

public class Time {
    


    static float initTime = System.nanoTime()/1000000000;

    public Time(){
        
    }  

    public static float dTime(float startTime){                      // Returns a Delta of time between an input Time and the current Time
        return (System.nanoTime()/1000000000) - startTime;
    }

    public static float time(){
        return System.nanoTime()/1000000000;                           //Basically just a synonym for System.nanoTime;
    }

    public float getInitTime() {
        return initTime;
    }

}
