package entities.armours;

public class SkeletonArmour extends Armour {
    public SkeletonArmour() {
        // Call the Armour constructor with name, weight, and dragCoefficient values specific to Skeleton Armour
        super("Skeleton Armour", 15.0, 0.50);
    }

    @Override
    public String toString() {
        return "SkeletonArmour{name='" + getName() + "', weight=" + getWeight() + ", dragCoefficient=" + getDragCoefficient() + ", isEquipped=" + isEquipped() + "}";
    }
}
