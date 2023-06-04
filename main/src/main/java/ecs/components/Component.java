package ecs.components;

import ecs.GameObj;

import java.awt.Graphics2D;

public class Component<T> {

    protected final String name;
    protected GameObj gameObj;

    protected Component(String name) {
        this.name = name;
    }

    public void update(double deltaTime) {
        return;
    }

    public void draw(Graphics2D g2) {
        return;
    }

    public void setGameObj(GameObj gameObj) {
        this.gameObj = gameObj;
    }

}
