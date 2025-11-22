package main;

import entities.Player;
import gameLogic.EquationManager;

import javax.swing.*;
import java.awt.*;

/**
 * EquationsPanel is a JPanel subclass that represents the panel where equations
 * will be displayed in the application. It is currently configured with a
 * preferred size and a gray background color.
 */
public class EquationsPanel extends JPanel {
    private EquationManager equationsManager;
    private Player player;
    private Timer refreshTimer;

    /**
     * Creates an EquationsPanel configured with a preferred size and background.
     *
     * <p>This panel is intended to display equations or related UI on the side
     * of the main game area. Currently it sets a fixed preferred size and gray background.</p>
     */
    EquationsPanel(Player player) {
        this.setPreferredSize((new Dimension(200, 100)));
        this.setBackground(Color.GRAY);
        this.player = player;
        this.equationsManager = new EquationManager(player);
        double terminalVelocity = equationsManager.getTerminalVelocity();
        System.out.println("Terminal Velocity: " + terminalVelocity);


        refreshTimer = new Timer(100, e -> repaint());
        refreshTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));

        double terminalVelocity = equationsManager.getTerminalVelocity();
        double playerWeight = player.getPlayerWeight();
        double dragCoefficient = player.getPlayerDragCoefficient();
        double frontalArea = player.getPlayerFrontalArea();

        g2d.drawString("Terminal Velocity: " + String.format("%.2f", terminalVelocity), 10, 30);
        g2d.drawString("Weight: " + String.format("%.2f", playerWeight), 10, 50);
        g2d.drawString("Drag Coefficient: " + String.format("%.2f", dragCoefficient), 10, 70);
        g2d.drawString("Frontal Area: " + String.format("%.2f", frontalArea), 10, 90);
    }

    public void refresh() {
        repaint();
    }
}
