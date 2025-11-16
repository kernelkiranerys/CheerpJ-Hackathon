package entities.armours;

public class CyborgArmour extends Armour {
    public CyborgArmour() {
        // Call the Armour constructor with name, weight, and dragCoefficient values specific to Cyborg Armour
        super("Cyborg Armour", 25.0, 0.60);
    }

    @Override
    public String toString() {
        return "CyborgArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }

}
