package util;

public class Time {

    private static final long startedTime = System.nanoTime();
    private static double lastFrameRate = 0;

    public static double getElapsedTime() {
        return (System.nanoTime() - Time.startedTime) * 1E-9;
    }

    public static double getDeltaTime() {
        double time = Time.getElapsedTime();
        double deltaTime = time - Time.lastFrameRate;
        Time.lastFrameRate = time;
        return deltaTime;
    }

}
