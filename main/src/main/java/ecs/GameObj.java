package ecs;

import ecs.components.Component;
import util.math.Transform;

import java.awt.*;
import java.util.HashMap;

public class GameObj {


    private final HashMap<Class<?>, Component<?>> components = new HashMap<>();
    private final String name;
    public final Transform transform;

    public GameObj(String name, Transform transform) {
        this.name = name;
        this.transform = transform;
    }

    public void addComponent(Component<?> component) {
        this.components.put(component.getClass(), component);
        component.setGameObj(this);
    }

    public <T extends Component<?>> T getComponent(Class<T> componentClass) {
        return componentClass.cast(this.components.get(componentClass));
    }

    public void update(double deltaTime) {
        for (Component<?> c : this.components.values())
            c.update(deltaTime);
    }

    public void draw(Graphics2D g2) {
        for (Component<?> c : this.components.values())
            c.draw(g2);
    }

    public String getName() {
        return name;
    }
}
