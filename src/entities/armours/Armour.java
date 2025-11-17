package entities.armours;

public abstract class Armour {

    private String name;
    private double weight;
    private double dragCoefficient;
    private boolean isEquipped;


    public Armour(String name, double weight, double dragCoefficient) {
        this.name = name;
        this.weight = weight;
        this.dragCoefficient = dragCoefficient;
        this.isEquipped = false;
    }

    /**
     * Equips this armour if it is not already equipped and prints a status message.
     * If already equipped, a message indicating so is printed.
     */
    public void equip() {
        if (!isEquipped) {
            isEquipped = true;
            System.out.println(name + " has been equipped.");
        } else {
            System.out.println(name + " is already equipped.");
        }
    }

    /**
     * Unequips this armour if it is currently equipped and prints a status message.
     * If not equipped, a message indicating so is printed.
     */
    public void unequip() {
        if (isEquipped) {
            isEquipped = false;
            System.out.println(name + " has been unequipped.");
        } else {
            System.out.println(name + " is not equipped.");
        }
    }

    /**
     * Returns the name of this armour.
     * @return the armour name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the weight of this armour.
     * @return the armour weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the drag coefficient of this armour, used for movement or physics calculations.
     * @return the drag coefficient
     */
    public double getDragCoefficient() {
        return dragCoefficient;
    }

    /**
     * Indicates whether this armour is currently equipped.
     * @return true if equipped; false otherwise
     */
    public boolean isEquipped() {
        return isEquipped;
    }
}
