package edu.gsu.GUI;

import javax.swing.*;
import java.awt.*;

public class StartingPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame("BoBo Tour Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanel panel = new LoginPanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

    }

}
