package main;

import javax.swing.JFrame;
import game.GamePanel;
import game.InputHandler;

public class Main {
    public static final int WIDTH = 400, HEIGHT = 800;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Game");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel(frame); // Pass the frame
        frame.add(gamePanel);
        frame.addKeyListener(new InputHandler(gamePanel));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
