package src.tools;

public class Time {
    
    private long initTime;

    Time(){
        initTime = System.nanoTime();
    }  

    public static long dTime(long startTime){                      // Returns a Delta of time between an input Time and the current Time
        return System.nanoTime() - startTime;
    }

    public static long time(){
        return System.nanoTime();                           //Basically just a synonym for System.nanoTime;
    }

}
