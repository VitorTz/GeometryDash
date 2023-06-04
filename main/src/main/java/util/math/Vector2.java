package util.math;

public class Vector2 {

    public  float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this(0f, 0f);
    }

    public void set(float x, float y) {
        this.x = x;;
        this.y = y;
    }

    public void set(Vector2 v) {
        this.set(v.x, v.y);
    }

    public Vector2 copy() {
        return new Vector2(this.x, this.y);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y,  2));
    }

    public void normalize() {
        double magnitude = this.getMagnitude();
        if (magnitude > 1) {
            this.x /= (float) magnitude;
            this.y /= (float) magnitude;
        }
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
