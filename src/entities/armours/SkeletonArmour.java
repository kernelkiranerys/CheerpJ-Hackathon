package entities.armours;

public class SkeletonArmour extends Armour {
    public SkeletonArmour() {

        super("Skeleton Armour", 15.0, 0.50, "/res/squirrel_skeletal.png", "/res/squirrel_skinned.png");
    }

    @Override
    public String toString() {
        return "SkeletonArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
