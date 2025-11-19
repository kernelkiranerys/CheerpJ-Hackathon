package main;

import javax.swing.*;
import java.awt.*;

/**
 * The ArmourPanel class represents a panel that contains options for
 * selecting different types of armour. It extends JPanel and adds
 * specific components and behavior for armour selection.
 */
public class ArmourPanel extends JPanel {

    JButton mechArmourButton = new JButton("Mechanical Armour");
    JButton CyborgArmourButton = new JButton("Cyborg Armour");
    JButton KnightArmourButton = new JButton("Knight Armour");
    JButton SkeletonArmourButton = new JButton("Skeleton Armour");
    JButton SkyDiveArmourButton = new JButton("Sky Diver Armour");

    /**
     * Creates an ArmourPanel with a preferred size, background color and
     * adds the mechanical armour button to the panel.
     */
    ArmourPanel() {
        this.setPreferredSize((new Dimension(200, 100)));
        this.setBackground(Color.GRAY);
        this.add(mechArmourButton);
        this.add(CyborgArmourButton);
        this.add(KnightArmourButton);
        this.add(SkeletonArmourButton);
        this.add(SkyDiveArmourButton);
    }
}
