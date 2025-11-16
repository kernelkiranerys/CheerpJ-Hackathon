package entities.armours;

public class MechArmour extends Armour {
    public MechArmour() {
        // Call the Armour constructor with name, weight, and dragCoefficient values specific to Mech Armour
        super("Mech Armour", 40.0, 0.85);
    }

    @Override
    public String toString() {
        return "MechArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
