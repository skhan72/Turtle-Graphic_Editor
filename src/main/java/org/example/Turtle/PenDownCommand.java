package org.example.Turtle;

public class PenDownCommand implements Command {
    private final Turtle turtle;
    private boolean prevPenDown;

    public PenDownCommand(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void execute() {
        prevPenDown = turtle.isPenDown();
        turtle.penDown();
    }

    @Override
    public void undo() {
        if (!prevPenDown) {
            turtle.penUp();
        } else {
            turtle.penDown(); // No change, but ensures consistency
        }
    }
}

