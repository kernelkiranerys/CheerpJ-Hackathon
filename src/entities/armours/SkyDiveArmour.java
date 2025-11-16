package entities.armours;

public class SkyDiveArmour extends Armour{
    public SkyDiveArmour() {
        // Call the Armour constructor with name, weight, and dragCoefficient values specific to Sky Dive Armour
        super("Sky Dive Armour", 10.0, 0.30);
    }

    @Override
    public String toString() {
        return "SkyDiveArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
