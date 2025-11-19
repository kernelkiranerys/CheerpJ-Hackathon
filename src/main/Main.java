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

        MainContainer mainContainer = new MainContainer();

        window.add(mainContainer);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        System.out.println(mainContainer.getGamePanel());
        mainContainer.getGamePanel().requestFocusInWindow();
        mainContainer.getGamePanel().startGameThread();

    }
}