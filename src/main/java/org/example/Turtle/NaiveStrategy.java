package org.example.Turtle;

public class NaiveStrategy implements DrawingStrategy {

    @Override
    public void drawLine(Matrix m, double x0, double y0, double x1, double y1) {
        double dx = x1 - x0;
        double dy = y1 - y0;

        int steps = (int)(Math.max(Math.abs(dx), Math.abs(dy)));

        if (steps == 0) {
            m.setCell((int)x0, (int)y0, '#');
            return;
        }

        double xInc = dx / steps;
        double yInc = dy / steps;

        double x = x0;
        double y = y0;

        for (int i = 0; i <= steps; i++) {
            m.setCell((int)Math.round(x), (int)Math.round(y), '#');
            x += xInc;
            y += yInc;
        }
    }
}
