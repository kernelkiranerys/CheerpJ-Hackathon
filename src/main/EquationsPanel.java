package main;

import javax.swing.*;
import java.awt.*;

/**
 * EquationsPanel is a JPanel subclass that represents the panel where equations
 * will be displayed in the application. It is currently configured with a
 * preferred size and a gray background color.
 */
public class EquationsPanel extends JPanel {

    /**
     * Creates an EquationsPanel configured with a preferred size and background.
     *
     * <p>This panel is intended to display equations or related UI on the side
     * of the main game area. Currently it sets a fixed preferred size and gray background.</p>
     */
    EquationsPanel() {
        this.setPreferredSize((new Dimension(200, 100)));
        this.setBackground(Color.GRAY);
    }
}
