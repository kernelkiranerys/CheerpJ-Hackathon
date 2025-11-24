package gameLogic;

import entities.Player;

public class EquationManager {
    private double terminalVelocity;
    private Player player;

    private double velocity = 0;
    private double deltaTime = 0.016;
    private double gravity = 9.81;

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

    public double updateVelocity() {
        double weight = player.getPlayerWeight();
        double dragCoefficient = player.getPlayerDragCoefficient();
        double frontalArea = player.getPlayerFrontalArea();
        double airDensity = 1.225;

        double dragForce = 0.5 * airDensity * velocity * velocity * dragCoefficient * frontalArea;

        double acceleration = gravity - (dragForce / weight);

        velocity += acceleration * deltaTime;

        double TerminalVelocity = getTerminalVelocity();
        if (velocity > TerminalVelocity) {
            velocity = TerminalVelocity;
        }
        return  velocity;
    }
}
