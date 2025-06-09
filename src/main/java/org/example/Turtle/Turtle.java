package org.example.Turtle;

/**
 * The {@code Turtle} class represents a drawable turtle that can move,
 * turn, and draw lines on a {@link Matrix} using a specified {@link DrawingStrategy}.
 * It supports undo functionality and keeps track of its drawing state.
 */
public class Turtle {
    private double x, y;
    private double direction;
    private boolean penDown;
    private final Matrix matrix;
    private DrawingStrategy strategy;

    private TurtleState prevState;

    /**
     * Constructs a Turtle object.
     *
     * @param matrix   the drawing surface
     * @param strategy the drawing strategy used to render lines
     */
    public Turtle(Matrix matrix, DrawingStrategy strategy) {
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        this.penDown = false;
        this.matrix = matrix;
        this.strategy = strategy;
    }

    /**
     * Saves the current state of the turtle (position, direction, pen state, and matrix snapshot)
     * for undo functionality.
     */
    public void saveState() {
        prevState = new TurtleState(x, y, direction, penDown, matrix);
    }

    /**
     * Undoes the last saved state change by restoring the previous state.
     */
    public void undo() {
        if (prevState != null) {
            this.x = prevState.x;
            this.y = prevState.y;
            this.direction = prevState.direction;
            this.penDown = prevState.penDown;
            this.matrix.copyFrom(prevState.matrixCopy);
        }
    }

    /**
     * Moves the turtle forward by the specified distance in the current direction.
     * If the pen is down, draws a line during the movement.
     *
     * @param distance the distance to move
     */
    public void move(double distance) {
        double radians = Math.toRadians(direction);
        double newX = x + distance * Math.cos(radians);
        double newY = y + distance * Math.sin(radians);
        if (penDown) {
            strategy.drawLine(matrix, x, y, newX, newY);
        }
        x = newX;
        y = newY;
    }

    /**
     * Turns the turtle by a specified angle in degrees.
     * Positive values turn clockwise, and negative values turn counter-clockwise.
     *
     * @param angle the angle in degrees to turn
     */
    public void turn(double angle) {
        direction = (direction + angle) % 360;
    }

    /**
     * Lifts the pen up, so movement does not draw.
     */
    public void penUp() {
        penDown = false;
    }

    /**
     * Puts the pen down, so movement draws lines.
     */
    public void penDown() {
        penDown = true;
    }

    /**
     * Returns the current X position of the turtle.
     *
     * @return the X coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the current Y position of the turtle.
     *
     * @return the Y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the current direction the turtle is facing.
     *
     * @return the direction in degrees
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Sets a new drawing strategy for the turtle.
     *
     * @param strategy the new drawing strategy
     */
    public void setStrategy(DrawingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Checks if the pen is currently down.
     *
     * @return {@code true} if the pen is down, {@code false} otherwise
     */
    public boolean isPenDown() {
        return penDown;
    }
}
