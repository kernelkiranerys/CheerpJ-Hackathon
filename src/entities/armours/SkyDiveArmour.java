package entities.armours;

public class SkyDiveArmour extends Armour{
    public SkyDiveArmour() {

        super("Sky Dive Armour", 10.0, 0.30);
    }

    @Override
    public String toString() {
        return "SkyDiveArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
