package entities;

public class Squirrel {
    private Parachute parachute = null;

    public Parachute getParachute() {
        return parachute;
    }

    public void equipParachute(Parachute parachute) {
        this.parachute = parachute;
    }

    public void unequipParachute(Parachute parachute) {
        this.parachute = null;
    }
}
