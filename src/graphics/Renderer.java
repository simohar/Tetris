package graphics;

import java.awt.Graphics;
import java.awt.Color;

public class Renderer {
    public static void drawGrid(Graphics g, int rows, int cols, int blockSize) {
        g.setColor(Color.GRAY);
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * blockSize, cols * blockSize, i * blockSize); // Horizontal lines
        }
        for (int j = 0; j <= cols; j++) {
            g.drawLine(j * blockSize, 0, j * blockSize, rows * blockSize); // Vertical lines
        }
    }

    public static void drawShape(Graphics g, int[][] shape, int x, int y, int blockSize, Color color) {
        g.setColor(color);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    g.fillRect((x + j) * blockSize, (y + i) * blockSize, blockSize, blockSize);
                }
            }
        }
    }
}
