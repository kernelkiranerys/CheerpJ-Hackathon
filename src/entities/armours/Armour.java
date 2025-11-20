package entities.armours;

public abstract class Armour {

    private final String name;
    private final double weight;
    private final double dragCoefficient;
    private boolean isEquipped;
    private final String spritePathGlide;
    private final String spritePathDive;


    public Armour(String name, double weight, double dragCoefficient, String spritePathGlide, String spritePathDive) {
        this.name = name;
        this.weight = weight;
        this.dragCoefficient = dragCoefficient;
        this.isEquipped = false;
        this.spritePathGlide = spritePathGlide;
        this.spritePathDive = spritePathDive;
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

    /**
     * Returns the sprite path used when gliding.
     * @return the glide sprite path
     */
    public String getSpritePathGlide() {
        return spritePathGlide;
    }

    /**
     * Returns the sprite path used when diving.
     * @return the dive sprite path
     */
    public String getSpritePathDive() {
        return spritePathDive;
    }
}
