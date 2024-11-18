package main;

import javax.swing.JFrame;

public class Main {
    public static final int WIDTH = 400, HEIGHT = 800;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Game");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // TODO : Add the game panel

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
