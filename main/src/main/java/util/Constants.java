package util;


import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.io.File;

public class Constants {

    // Window
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static final String SCREEN_TITLE = "Geometry Dash";
    public static final int FPS = 120;
    public static final long FPS_IN_MILLIS = 1000L / FPS;
    public static final Color SCREEN_BG_COLOR = new Color(40, 44, 52);

    // Player
    public static final float PLAYER_SPEED = 200f;
    public static final float PLAYER_JUMP_DISTANCE = 80f;
    public static final Color PLAYER_COLOR_A = new Color(69, 242, 241);
    public static final Color PLAYER_COLOR_B = new Color(208, 95, 217);
    public static final int PLAYER_SPRITESHEET_SPACING = 2;
    public static final List<File> PLAYER_SPRITESHEETS = List.of(
        new File("main/src/main/resources/SpriteSheet/player/layerOne.png"),
        new File("main/src/main/resources/SpriteSheet/player/layerTwo.png"),
        new File("main/src/main/resources/SpriteSheet/player/layerThree.png")
    );
    public static final Dimension PLAYER_DIMENSION = new Dimension(42, 42);
}
