/*
import entities.Parachute;
import entities.Squirrel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerDeprecated implements KeyListener {
    private Squirrel squirrel;



    public KeyHandlerDeprecated(Squirrel squirrel) {
        this.squirrel = squirrel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            Parachute parachute = squirrel.getParachute();
            if (parachute != null){
                parachute.deploy();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
*/