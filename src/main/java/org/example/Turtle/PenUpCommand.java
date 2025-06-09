package org.example.Turtle;

public class PenUpCommand implements Command {
    private final Turtle turtle;
    private boolean prevPenDown;

    public PenUpCommand(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void execute() {
        prevPenDown = turtle.isPenDown();
        turtle.penUp();
    }

    @Override
    public void undo() {
        if (prevPenDown) {
            turtle.penDown();
        } else {
            turtle.penUp(); // No change, but ensures consistency
        }
    }
}
