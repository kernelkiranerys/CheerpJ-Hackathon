package entities.armours;

public class KnightArmour extends Armour {
    public KnightArmour() {

        super("Knight Armour", 30.0, 0.75, "/res/squirrel_knight.png", "/res/squirrel_skinned.png");
    }

    @Override
    public String toString() {
        return "KnightArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
