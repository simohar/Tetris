// File: game/GamePanel.java
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class GamePanel extends JPanel implements Runnable {
    private static final int BLOCK_SIZE = 30;
    private static final int ROWS = 20, COLS = 10;
    private Grid grid;
    private Shape currentShape;
    private int shapeX = 3, shapeY = 0; // Starting position
    private Thread gameThread;
    private boolean running = false;
    private int score = 0;
    private JFrame frame;

    public GamePanel(JFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE));
        setBackground(Color.black);
        grid = new Grid(ROWS, COLS);

        startGame();
    }

    public void startGame() {
        currentShape = getRandomShape();
        gameThread = new Thread(this);
        running = true;
        gameThread.start();
    }

    private Shape getRandomShape() {
        int idx = (int) (Math.random() * Shape.SHAPES.length);
        return new Shape(idx);
    }

    @Override
    public void run() {
        while (running) {
            updateGame();
            repaint();

            try {
                Thread.sleep(500); // Adjust the speed as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateGame() {
        if (grid.isValidPosition(currentShape, shapeX, shapeY + 1)) {
            shapeY++;
        } else {
            grid.addShape(currentShape, shapeX, shapeY);
            // Check for completed lines here
            currentShape = getRandomShape();
            shapeX = 3;
            shapeY = 0;
        }
        if (!grid.isValidPosition(currentShape, shapeX, shapeY)) {
            running = false; // Stop the game loop
            System.out.println("Game Over!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.render(g, BLOCK_SIZE);
        drawShape(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);

    }

    private void drawShape(Graphics g) {
        int[][] blocks = currentShape.getShape();
        g.setColor(currentShape.getColor());

        for (int i = 0; i < blocks.length; i++)
            for (int j = 0; j < blocks[i].length; j++)
                if (blocks[i][j] == 1)
                    g.fillRect((shapeX + j) * BLOCK_SIZE, (shapeY + i) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (grid.isValidPosition(currentShape, shapeX - 1, shapeY))
                shapeX--;
        } else if (key == KeyEvent.VK_RIGHT) {
            if (grid.isValidPosition(currentShape, shapeX + 1, shapeY))
                shapeX++;
        } else if (key == KeyEvent.VK_DOWN) {
            if (grid.isValidPosition(currentShape, shapeX, shapeY + 1))
                shapeY++;
        } else if (key == KeyEvent.VK_UP) {
            currentShape.rotate();
            if (!grid.isValidPosition(currentShape, shapeX, shapeY))
                currentShape.rotate(); // Rotate back if invalid
        }
    }
}
