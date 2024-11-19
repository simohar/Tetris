// File: game/Shape.java
package game;

import java.awt.Color;

public class Shape {
    private int[][] shape;
    private Color color;

    // Tetromino shapes
    public static final int[][][] SHAPES = {
            // I Shape
            {
                    {0, 0, 0, 0},
                    {1, 1, 1, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            },
            // J Shape
            {
                    {1, 0, 0},
                    {1, 1, 1},
                    {0, 0, 0}
            },
            // L Shape
            {
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0}
            },
            // O Shape
            {
                    {1, 1},
                    {1, 1}
            },
            // S Shape
            {
                    {0, 1, 1},
                    {1, 1, 0},
                    {0, 0, 0}
            },
            // T Shape
            {
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 0, 0}
            },
            // Z Shape
            {
                    {1, 1, 0},
                    {0, 1, 1},
                    {0, 0, 0}
            }
    };

    // Corresponding colors for each shape
    public static final Color[] COLORS = {
            Color.cyan, Color.blue, Color.orange,
            Color.yellow, Color.green, Color.magenta, Color.red
    };

    public Shape(int idx) {
        shape = SHAPES[idx];
        color = COLORS[idx];
    }

    // Getters and other methods
    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    // Rotation method
    public void rotate() {
        int n = shape.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                rotated[j][n - i - 1] = shape[i][j];

        shape = rotated;
    }
}
