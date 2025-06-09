package org.example.Turtle;

/**
 * A simple drawing strategy that supports horizontal, vertical,
 * and basic diagonal lines using rounded coordinates.
 */
public class SimpleDrawingStrategy implements DrawingStrategy {

    /**
     * Draws a line from (x1, y1) to (x2, y2) on the matrix using `#` characters.
     * Supports horizontal, vertical, and approximate diagonal lines.
     *
     * @param matrix the drawing surface
     * @param x1     starting x-coordinate
     * @param y1     starting y-coordinate
     * @param x2     ending x-coordinate
     * @param y2     ending y-coordinate
     */
    @Override
    public void drawLine(Matrix matrix, double x1, double y1, double x2, double y2) {
        // Round coordinates to nearest integer values
        int ix1 = (int) Math.round(x1);
        int iy1 = (int) Math.round(y1);
        int ix2 = (int) Math.round(x2);
        int iy2 = (int) Math.round(y2);

        // Case 1: Vertical line
        if (ix1 == ix2) {
            for (int y = Math.min(iy1, iy2); y <= Math.max(iy1, iy2); y++) {
                matrix.setCell(ix1, y, '#');
            }
        }
        // Case 2: Horizontal line
        else if (iy1 == iy2) {
            for (int x = Math.min(ix1, ix2); x <= Math.max(ix1, ix2); x++) {
                matrix.setCell(x, iy1, '#');
            }
        }
        // Case 3: Diagonal or angled line (approximate)
        else {
            int dx = ix2 - ix1;
            int dy = iy2 - iy1;
            int steps = Math.max(Math.abs(dx), Math.abs(dy)); // Total number of steps for line
            for (int i = 0; i <= steps; i++) {
                int x = (int) Math.round(ix1 + i * dx / (double) steps);
                int y = (int) Math.round(iy1 + i * dy / (double) steps);
                matrix.setCell(x, y, '#');
            }
        }
    }
}
