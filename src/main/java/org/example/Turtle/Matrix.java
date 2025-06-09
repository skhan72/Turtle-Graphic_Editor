package org.example.Turtle;

public class Matrix {
    private final int width;
    private final int height;
    private final char[][] grid;

    /**
     * Creates a matrix of given width and height, filled with spaces.
     */
    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];

        clear(); // fill with ' '
    }

    /**
     * Clears the matrix by filling with spaces.
     */
    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = ' ';
            }
        }
    }

    /**
     * Sets a cell to a character, if within bounds.
     */
    public void setCell(int x, int y, char c) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            grid[height - y - 1][x] = c;
        }
    }

    public Matrix copy() {
        Matrix copy = new Matrix(width, height);
        for (int i = 0; i < height; i++) {
            System.arraycopy(this.grid[i], 0, copy.grid[i], 0, width);
        }
        return copy;
    }

    public void copyFrom(Matrix other) {
        for (int i = 0; i < height; i++) {
            System.arraycopy(other.grid[i], 0, this.grid[i], 0, width);
        }
    }

    /**
     * Prints the matrix to the console.
     */
    public void print() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}
