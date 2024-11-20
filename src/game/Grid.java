// File: game/Grid.java
package game;

import java.awt.Color;
import java.awt.Graphics;

public class Grid {
    private int rows, cols;
    private Color[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Color[rows][cols];
    }

    // Add shape to the grid
    public void addShape(Shape shape, int x, int y) {
        int[][] blocks = shape.getShape();
        Color color = shape.getColor();

        for (int i = 0; i < blocks.length; i++)
            for (int j = 0; j < blocks[i].length; j++)
                if (blocks[i][j] == 1)
                    grid[y + i][x + j] = color;
    }

    // Check if a position is valid
    public boolean isValidPosition(Shape shape, int x, int y) {
        int[][] blocks = shape.getShape();

        for (int i = 0; i < blocks.length; i++)
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 1) {
                    int newX = x + j;
                    int newY = y + i;

                    if (newX < 0 || newX >= cols || newY < 0 || newY >= rows)
                        return false;

                    if (grid[newY][newX] != null)
                        return false;
                }
            }

        return true;
    }

    // Render the grid
    public void render(Graphics g, int blockSize) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != null) {
                    g.setColor(grid[i][j]);
                    g.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);
                }
                g.setColor(Color.black);
                g.drawRect(j * blockSize, i * blockSize, blockSize, blockSize);
            }
    }
}
