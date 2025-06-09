package org.example.Turtle;

public class TraceCommand implements Command {
    private final Turtle turtle;
    private final double distance;

    public TraceCommand(Turtle turtle, double distance) {
        this.turtle = turtle;
        this.distance = distance;
    }

    @Override
    public void execute() {
        turtle.saveState();
        turtle.penDown();              // Enable drawing
        turtle.move(distance);         // Move and draw
    }

    @Override
    public void undo() {
        turtle.undo();                 // Restore position and pen state
    }
}
