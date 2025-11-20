package entities.armours;

public class CyborgArmour extends Armour {
    public CyborgArmour() {

        super("Cyborg Armour", 25.0, 0.60, "/res/squirrel_cyborg.png", "/res/squirrel_skinned.png");
    }

    @Override
    public String toString() {
        return "CyborgArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }

}
