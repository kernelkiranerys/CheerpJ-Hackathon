package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Flying Squirrel");

        JPanel mainContainer = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize((new Dimension(200, 575)));
        leftPanel.setBackground(Color.GRAY);

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize((new Dimension(200, 575)));
        rightPanel.setBackground(Color.GRAY);


        GamePanel gamePanel = new GamePanel();

        mainContainer.add(leftPanel, BorderLayout.WEST);
        mainContainer.add(gamePanel, BorderLayout.CENTER);
        mainContainer.add(rightPanel, BorderLayout.EAST);

        window.add(mainContainer);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}