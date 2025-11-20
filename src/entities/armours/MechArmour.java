package entities.armours;

public class MechArmour extends Armour {
    public MechArmour() {

        super("Mech Armour", 40.0, 0.85, "/images/squirrel_mech.png", "/images/squirrel_mech.png");
    }

    @Override
    public String toString() {
        return "MechArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
