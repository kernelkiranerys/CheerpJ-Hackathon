package main;

import entities.Player;
import entities.armours.Armour;
import gameLogic.ArmourSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The ArmourPanel class represents a panel that contains options for
 * selecting different types of armour. It extends JPanel and adds
 * specific components and behavior for armour selection.
 */
public class ArmourPanel extends JPanel {

    private JButton mechArmourButton     = new JButton("Mechanical Armour");
    private JButton cyborgArmourButton   = new JButton("Cyborg Armour");
    private JButton knightArmourButton   = new JButton("Knight Armour");
    private JButton skeletonArmourButton = new JButton("Skeleton Armour");
    private JButton skyDiveArmourButton  = new JButton("Sky Diver Armour");

    private ArmourSelector armourSelector;

    public ArmourPanel(Player player) {
        armourSelector = new ArmourSelector();
        setPreferredSize(new Dimension(200, 100));
        setBackground(Color.GRAY);

        setupActionCommands();
        setupButtonListeners(player);
        addArmourButtons();
    }

    /**
     * Set the action commands for all buttons.
     */
    private void setupActionCommands() {
        mechArmourButton.setActionCommand("MECH_ARMOUR");
        cyborgArmourButton.setActionCommand("CYBORG_ARMOUR");
        knightArmourButton.setActionCommand("KNIGHT_ARMOUR");
        skeletonArmourButton.setActionCommand("SKELETON_ARMOUR");
        skyDiveArmourButton.setActionCommand("SKYDIVE_ARMOUR");

        mechArmourButton.setFocusable(false);
        cyborgArmourButton.setFocusable(false);
        knightArmourButton.setFocusable(false);
        skeletonArmourButton.setFocusable(false);
        skyDiveArmourButton.setFocusable(false);
    }

    /**
     * Set up the listeners for all buttons.
     */
    private void setupButtonListeners(Player player) {
        mechArmourButton.addActionListener(e -> selectArmour(player, 3));
        cyborgArmourButton.addActionListener(e -> selectArmour(player, 1));
        knightArmourButton.addActionListener(e -> selectArmour(player, 0));
        skeletonArmourButton.addActionListener(e -> selectArmour(player, 2));
        skyDiveArmourButton.addActionListener(e -> selectArmour(player, 4));
    }

    /**
     * Add all buttons to the panel.
     */
    private void addArmourButtons() {
        add(mechArmourButton);
        add(cyborgArmourButton);
        add(knightArmourButton);
        add(skeletonArmourButton);
        add(skyDiveArmourButton);
    }

    /**
     * Shared code to update player armour. Updates the player's armour
     * and associated sprite paths based on the selected armour
     */
    private void selectArmour(Player player, int choice) {
        Armour selectedArmour = armourSelector.selectArmour(choice);
        player.setPlayerArmour(selectedArmour);
        player.setPlayerDiveSpritePath(selectedArmour.getDiveSpritePath());
        player.setPlayerGlideSpritePath(selectedArmour.getGlideSpritePath());
        player.getPlayerImage();
        System.out.println(player.GetPlayerArmour().getName() + " selected!");
    }
}
