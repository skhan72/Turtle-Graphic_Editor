package org.example.Turtle;

public class Turtle {
    private double x, y;
    private double direction;
    private boolean penDown;
    private final Matrix matrix;
    private DrawingStrategy strategy;

    private TurtleState prevState;

    public Turtle(Matrix matrix, DrawingStrategy strategy) {
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        this.penDown = false;
        this.matrix = matrix;
        this.strategy = strategy;
    }

    public void saveState() {
        prevState = new TurtleState(x, y, direction, penDown, matrix);
    }

    public void undo() {
        if (prevState != null) {
            this.x = prevState.x;
            this.y = prevState.y;
            this.direction = prevState.direction;
            this.penDown = prevState.penDown;
            this.matrix.copyFrom(prevState.matrixCopy);
        }
    }

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

    public void turn(double angle) {
        direction = (direction + angle) % 360;
    }

    public void penUp() { penDown = false; }

    public void penDown() { penDown = true; }

    public double getX() { return x; }

    public double getY() { return y; }

    public double getDirection() { return direction; }

    public void setStrategy(DrawingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isPenDown() {
        return penDown;
    }
}