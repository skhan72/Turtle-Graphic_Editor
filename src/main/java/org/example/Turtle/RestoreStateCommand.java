package org.example.Turtle;

public class RestoreStateCommand implements Command {
    private final Turtle turtle;

    public RestoreStateCommand(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void execute() {
        turtle.undo();
    }

    @Override
    public void undo() {
        // Do nothing
    }
}

