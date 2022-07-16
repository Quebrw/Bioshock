package Gamestate;

public enum Gamestate {

    // Possible Gamestates
    MENU, PLAYING, OPTIONS, QUIT, TITLE, DEATH, VICTORY;

    // When booting up the Game, the title should appear first
    public static Gamestate state = TITLE;
}
