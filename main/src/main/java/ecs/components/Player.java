package ecs.components;

import ecs.GameObj;
import util.Constants;
import util.SpriteSheet;
import util.math.Transform;
import window.KL;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.List;


public class Player extends Component<Player> {

    private Color colorA, colorB;
    private final List<SpriteSheet> spriteSheets;
    private int currentPlayerImageIndex = 0;

    public Player() {
        super("PlayerComponent");
        this.spriteSheets = Constants.PLAYER_SPRITESHEETS.stream().map(
                f -> new SpriteSheet(f, Constants.PLAYER_DIMENSION, Constants.PLAYER_SPRITESHEET_SPACING)
        ).toList();
        this.setColorA(Constants.PLAYER_COLOR_A);
        this.setColorB(Constants.PLAYER_COLOR_B);
    }

    private void move(double deltaTime) {
        this.gameObj.transform.position.x += deltaTime * this.gameObj.transform.speed * this.gameObj.transform.direction.x;
    }

    private void handleInput() {
        Jump jump = this.gameObj.getComponent(Jump.class);
        Transform transform = this.gameObj.transform;
        transform.direction.x = 1;
        transform.direction.y = 0;

        if (KL.isPressed(KeyEvent.VK_SPACE)) {
            jump.jump();
        }
        if (KL.isPressed(KeyEvent.VK_LEFT)) {
            jump.cancelJump();
        }

    }

    @Override
    public void update(double deltaTime) {
        this.handleInput();
        this.move(deltaTime);
    }

    @Override
    public void draw(Graphics2D g2) {
        for (SpriteSheet s : this.spriteSheets)
            s.get(this.currentPlayerImageIndex).draw(g2);
    }

    @Override
    public void setGameObj(GameObj gameObj) {
        super.setGameObj(gameObj);
        this.gameObj.addComponent(new Jump(Constants.PLAYER_JUMP_DISTANCE));
        this.gameObj.transform.setSpeed(Constants.PLAYER_SPEED);
        this.gameObj.transform.direction.x = 1;
        for (SpriteSheet sheet : this.spriteSheets)
            sheet.getSprites().forEach(s -> s.setGameObj(gameObj));
    }

    public void setColorA(Color colorA) {
        this.colorA = colorA;
        this.spriteSheets.get(0).paintSpriteSheet(this.colorA);
    }

    public void setColorB(Color colorB) {
        this.colorB = colorB;
        this.spriteSheets.get(1).paintSpriteSheet(this.colorB);
        this.spriteSheets.get(2).paintSpriteSheet(this.colorB);
    }

    public int getCurrentPlayerImageIndex() {
        return currentPlayerImageIndex;
    }

    public void setCurrentPlayerImageIndex(int currentPlayerImageIndex) {
        this.currentPlayerImageIndex = currentPlayerImageIndex;
    }

}
