package window;

import scene.LevelEditorScene;
import scene.Scene;
import util.Constants;
import util.Time;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame implements Runnable {


    private static Window window = null;

    private Scene currentScene;
    public Graphics doubleBuffer = null;
    Image doubleBufferImage = null;


    private Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(new KL());
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
            Window.window.init();
        }
        return Window.window;
    }

    private void init() {
        Window.changeScene(0);
    }

    public static void changeScene(int sceneId) {
        if (sceneId == 0) {
            Window.window.currentScene = new LevelEditorScene();
        } else {
            System.out.println("Nenhuma scena com o id " + sceneId + " encontrada!");
            System.exit(-1);
        }
    }

    private void update(double deltaTime) {
        this.currentScene.update(deltaTime);
        this.draw(this.getGraphics());
    }

    private void clear(Graphics g) {
        g.setColor(Constants.SCREEN_BG_COLOR);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void renderOffScreen(Graphics g) {
        this.clear(g);
        this.currentScene.draw((Graphics2D) g);

    }

    private void draw(Graphics g) {
        if (this.doubleBufferImage == null) {
            this.doubleBufferImage = this.createImage(this.getWidth(), this.getHeight());
            this.doubleBuffer = this.doubleBufferImage.getGraphics();
        }
        this.renderOffScreen(this.doubleBufferImage.getGraphics());
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(this.doubleBufferImage, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                double deltaTime = Time.getDeltaTime();
                this.update(deltaTime);
                TimeUnit.MILLISECONDS.sleep(Constants.FPS_IN_MILLIS);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
