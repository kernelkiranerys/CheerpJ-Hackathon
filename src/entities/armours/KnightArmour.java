package entities.armours;

public class KnightArmour extends Armour {
    public KnightArmour() {
        // Call the Armour constructor with name, weight, and dragCoefficient values specific to Knight Armour
        super("Knight Armour", 30.0, 0.75);
    }

    @Override
    public String toString() {
        return "KnightArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
