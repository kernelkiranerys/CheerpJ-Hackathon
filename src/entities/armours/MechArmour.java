package entities.armours;

public class MechArmour extends Armour {
    public MechArmour() {

        super("Mech Armour", 40.0, 0.85);
    }

    @Override
    public String toString() {
        return "MechArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
