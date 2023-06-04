package ecs.components;

import util.math.Transform;

public class Jump extends Component<Jump> {


    private boolean jumping;
    private final float yDistance;
    private float currentDistance;
    private float yPos;
    private boolean up, down;

    public Jump(float yDistance) {
        super("Jump");
        this.yDistance = yDistance;
        this.up = false;
        this.down = false;
        this.jumping = false;
    }

    public void jump() {
        if (!this.jumping) {
            this.jumping = true;
            this.up = true;
            this.down = false;
            this.currentDistance = 0f;
            this.yPos = this.gameObj.transform.position.y;
        }
    }

    @Override
    public void update(double deltaTime) {
        if (this.jumping) {
            Transform transform = this.gameObj.transform;;
            transform.rotation += deltaTime * 250f;
            transform.direction.y = this.up ? -1 : 1;
            transform.direction.normalize();
            double d = deltaTime * transform.speed * transform.direction.y;
            transform.position.y += d;
            this.currentDistance += Math.abs(d);

            if (this.yDistance <= this.currentDistance) {
                this.up = !this.up;
                this.down = !this.down;
                this.currentDistance = 0f;
                if (this.up) {
                    this.down = this.up = this.jumping = false;
                    transform.position.y = this.yPos;
                    transform.rotation = 0;
                }
            }
        }
    }

    public void cancelJump() {
        if (this.jumping) {
            this.jumping = false;
            this.gameObj.transform.direction.y = 0;
            this.gameObj.transform.rotation = 0;
        }
    }

    public boolean isJumping() {
        return jumping;
    }
}
