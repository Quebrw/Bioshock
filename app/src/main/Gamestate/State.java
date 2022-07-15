package Gamestate;

import test.GameLoop;

public class State {

    protected GameLoop gameLoop;

    public State(GameLoop gameLoop) {

        this.gameLoop = gameLoop;
    } 
    public GameLoop getGameLoop() {
    
        return gameLoop;
    }
    
}
