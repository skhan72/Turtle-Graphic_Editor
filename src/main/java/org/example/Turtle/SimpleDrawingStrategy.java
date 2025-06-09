package org.example.Turtle;

public class SimpleDrawingStrategy implements DrawingStrategy {

    @Override
    public void drawLine(Matrix matrix, double x1, double y1, double x2, double y2) {
        int ix1 = (int) Math.round(x1);
        int iy1 = (int) Math.round(y1);
        int ix2 = (int) Math.round(x2);
        int iy2 = (int) Math.round(y2);

        // Simple Bresenham-style horizontal/vertical line
        if (ix1 == ix2) {
            for (int y = Math.min(iy1, iy2); y <= Math.max(iy1, iy2); y++) {
                matrix.setCell(ix1, y, '#');
            }
        } else if (iy1 == iy2) {
            for (int x = Math.min(ix1, ix2); x <= Math.max(ix1, ix2); x++) {
                matrix.setCell(x, iy1, '#');
            }
        } else {
            // Diagonal (basic support)
            int dx = ix2 - ix1;
            int dy = iy2 - iy1;
            int steps = Math.max(Math.abs(dx), Math.abs(dy));
            for (int i = 0; i <= steps; i++) {
                int x = (int) Math.round(ix1 + i * dx / (double) steps);
                int y = (int) Math.round(iy1 + i * dy / (double) steps);
                matrix.setCell(x, y, '#');
            }
        }
    }
}
