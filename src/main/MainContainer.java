package main;

import javax.swing.*;
import java.awt.*;

/**
 * MainContainer is a JPanel that serves as the container for the main components
 * of the application, including the game area, equations display, and armour status.
 *
 * <p>This class extends JPanel and uses a BorderLayout to arrange its child
 * components: GamePanel in the center, EquationsPanel in the east, and
 * ArmourPanel in the west.</p>
 */
public class MainContainer extends JPanel {

    /**
     * The central GamePanel instance used to display the main game area.
     */
    private GamePanel gamePanel;

    /**
     * Creates a MainContainer and composes the main UI.
     *
     * <p>The container uses a BorderLayout and instantiates the child panels:
     * ArmourPanel (WEST), GamePanel (CENTER) and EquationsPanel (EAST).
     * This constructor performs the initial layout setup and adds the panels
     * to this container.</p>
     */
    MainContainer() {
        this.setLayout(new BorderLayout());
        gamePanel = new GamePanel();
        EquationsPanel equationsPanel = new EquationsPanel(gamePanel.getPlayer());

        ArmourPanel armourPanel = new ArmourPanel(gamePanel.getPlayer());

        this.add(armourPanel, BorderLayout.WEST);
        this.add(gamePanel, BorderLayout.CENTER);
        this.add(equationsPanel, BorderLayout.EAST);
    }

    /**
     * Returns the GamePanel used in this container.
     *
     * @return the GamePanel instance displayed at the center of the container
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
