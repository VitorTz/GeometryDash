package scene;

import ecs.GameObj;

import java.awt.Graphics2D;
import java.util.HashSet;

public abstract class Scene {

    protected final String name;
    protected final HashSet<GameObj> gameObjs = new HashSet<>();

    protected Scene(String name) {
        this.name = name;
        this.init();
    }

    public abstract void init();
    public abstract void update(double deltaTime);
    public abstract void draw(Graphics2D g2);

    public void addGameObj(GameObj gameObj) {
        this.gameObjs.add(gameObj);
    }

}
