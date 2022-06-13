public class Main {

    public static void main(String[] args) {
        GameLoop gameLoop = new GameLoop();
        Thread t1 = new Thread(gameLoop);
        t1.start();
    }
}
