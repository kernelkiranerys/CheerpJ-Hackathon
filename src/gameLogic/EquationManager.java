package gameLogic;

import entities.Player;

public class EquationManager {
    private double terminalVelocity;
    private Player player;

    public EquationManager(Player player) {
        this.player = player;
    }

    public double getTerminalVelocity() {
        double weight = player.getPlayerWeight();
        double dragCoefficient = player.getPlayerDragCoefficient();
        double frontalArea = player.getPlayerFrontalArea();
        System.out.println(weight);
        System.out.println(dragCoefficient);
        System.out.println(frontalArea);
        terminalVelocity = Math.sqrt((2 * weight) / (1.225 * dragCoefficient * frontalArea));
        return terminalVelocity;
    }
}
