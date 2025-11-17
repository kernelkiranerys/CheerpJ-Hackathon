package gameLogic;
import entities.armours.Armour;

import java.text.*;

public class ArmourSelector {
    private Armour[] availableArmours = new Armour[5];

    /**
     * Constructs an ArmourSelector and initializes the array with all available armour types.
     */
    public ArmourSelector() {
        availableArmours[0] = new entities.armours.KnightArmour();
        availableArmours[1] = new entities.armours.CyborgArmour();
        availableArmours[2] = new entities.armours.SkeletonArmour();
        availableArmours[3] = new entities.armours.MechArmour();
        availableArmours[4] = new entities.armours.SkyDiveArmour();
    }

    /**
     * Selects an armour from the available armours based on the provided choice index.
     *
     * @param choiceIndex the index of the armour to select (1-based)
     * @return the selected Armour object
     * @throws IllegalArgumentException if the choice index is out of valid range
     */
    public Armour selectArmour(int choiceIndex) {
        if (choiceIndex >= 0 && choiceIndex < availableArmours.length) {
            return availableArmours[choiceIndex - 1];
        }
        else {
            throw new IllegalArgumentException("Invalid armour choice: " + choiceIndex);
        }
    }
}
