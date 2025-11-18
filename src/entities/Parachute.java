package entities;

public class Parachute {
    private boolean isDeployed;
    private float dragCoefficient;

    public Parachute() {
        this.isDeployed = false;
        this.dragCoefficient = 1.5f; // Example drag coefficient
    }

    public void deploy() {
        if (!isDeployed) {
            isDeployed = true;
        }
    }

    public void retract() {
        if (isDeployed) {
            isDeployed = false;
        }
    }

    public boolean isDeployed() {
        return isDeployed;
    }

    public float getDragCoefficient() {
        return isDeployed ? dragCoefficient : 1.0f;
    }
}
