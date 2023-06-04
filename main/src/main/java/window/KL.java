package window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL extends KeyAdapter implements KeyListener {

    private static final boolean[] keys = new boolean[128];

    public static boolean isValidKey(int k) {
        return k >= 0 && k < KL.keys.length;
    }

    public static boolean isPressed(int e) {
        if (KL.isValidKey(e)) return KL.keys[e];
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KL.isValidKey(e.getKeyCode())) {
            KL.keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (KL.isValidKey(e.getKeyCode())) {
            KL.keys[e.getKeyCode()] = false;
        }
    }

}
