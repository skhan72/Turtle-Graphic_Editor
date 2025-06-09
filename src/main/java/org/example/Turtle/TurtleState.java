package org.example.Turtle;

public class TurtleState {
    public final double x, y, direction;
    public final boolean penDown;
    public final Matrix matrixCopy;

    public TurtleState(double x, double y, double direction, boolean penDown, Matrix matrix) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.penDown = penDown;
        this.matrixCopy = matrix.copy();
    }
}
