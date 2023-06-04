import ecs.components.Sprite;
import util.SpriteSheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SpriteSheetTest {

    public static void main(String[] args) {
        String outputFolder = "main/src/test/out/";
        SpriteSheet spriteSheet = new SpriteSheet(
                new File("main/src/main/resources/SpriteSheet/player/layerOne.png"),
                new Dimension(42, 42),
                2
        );
        int c = 0;
        for (Sprite s : spriteSheet.getSprites()) {
            File f = new File(outputFolder + c + ".png");
            c++;
            try {
                ImageIO.write(s.getImage(), "png", f);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

    }
}
