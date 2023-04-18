package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }
    //for some reason I get an error if I delete this, so I'll just leave it here

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //return the integer associated with each key pressed - in this case we'll use WASD at first
        if (code == KeyEvent.VK_W) // W = 57
        {
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) // A = 41
        {
            leftPressed  = true;
        }
        if (code == KeyEvent.VK_S) // S = 53
        {
            downPressed  = true;
        }
        if (code == KeyEvent.VK_D) // D = 44
        {
            rightPressed  = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if (code == KeyEvent.VK_A)
        {
            leftPressed  = false;
        }
        if (code == KeyEvent.VK_S)
        {
            downPressed  = false;
        }
        if (code == KeyEvent.VK_D)
        {
            rightPressed  = false;
        }
    } // the listener which inputs the keys

}
