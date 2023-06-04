package scene;

import ecs.GameObj;
import ecs.components.Player;
import util.math.Transform;
import java.awt.Graphics2D;

public class LevelEditorScene extends Scene {

    public LevelEditorScene() {
        super("LevelEditorScene");
    }

    @Override
    public void init() {
        GameObj player = new GameObj("Player", new Transform(100f, 600f));
        player.addComponent(new Player());
        this.addGameObj(player);
    }

    @Override
    public void update(double deltaTime) {
        for (GameObj g : this.gameObjs)
            g.update(deltaTime);
    }

    @Override
    public void draw(Graphics2D g2) {
        for (GameObj g : this.gameObjs)
            g.draw(g2);
    }
}
