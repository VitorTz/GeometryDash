package util.math;

public class Transform {

    public final Vector2 position;
    public final Vector2 scale;
    public final Vector2 direction;
    public float speed;
    public double rotation;

    public Transform(float x, float y) {
        this.position = new Vector2(x, y);
        this.direction = new Vector2(0f, 0f);
        this.scale = new Vector2(1f, 1f);
        this.rotation = 0;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Transform{" +
                "position=" + position +
                ", scale=" + scale +
                ", rotation=" + rotation +
                '}';
    }
}

