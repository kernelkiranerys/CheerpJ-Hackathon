package entities;

/**
 * Represents a simple parachute that can be deployed or retracted.
 * <p>
 * The parachute maintains a deployed state and a drag factor that can be
 * queried by other components (for example physics or movement systems).
 * Deployment and retraction change the internal state but do not perform any
 * external side effects by themselves.
 * </p>
 */
public class Parachute {
    private boolean deployed = false;
    private float dragFactor;


    /**
     * Creates a new Parachute instance.
     * <p>
     * By default, the parachute is not deployed and the drag factor is set to
     * 0.5f. The drag factor represents the relative amount of drag applied when
     * the parachute is deployed.
     * </p>
     */
    public Parachute() {
        this.deployed = false;
        this.dragFactor = 0.5f;
    }

    /**
     * Deploys the parachute.
     * <p>
     * If the parachute is already deployed this method has no effect.
     * </p>
     */
    public void deploy() {
        if (!this.deployed) {
            this.deployed = true;
        }
    }

    /**
     * Retracts the parachute.
     * <p>
     * If the parachute is already retracted this method has no effect.
     * </p>
     */
    public void retract() {
        if (this.deployed) {
            this.deployed = false;
        }
    }

    /**
     * Checks whether the parachute is currently deployed.
     *
     * @return true if the parachute is deployed, false otherwise
     */
    public boolean isDeployed() {
        return deployed;
    }

    /**
     * Returns the parachute's drag factor.
     * <p>
     * The drag factor is a float value representing how much drag the parachute
     * applies (for example to reduce falling speed). It is not modified by the
     * class outside of construction in the current implementation.
     * </p>
     *
     * @return the drag factor
     */
    public float getDragFactor() {
        return dragFactor;
    }
}
