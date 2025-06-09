package org.example.Turtle;

public class SaveStateCommand implements Command {
    private final Turtle turtle;

    public SaveStateCommand(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void execute() {
        turtle.saveState();
    }

    @Override
    public void undo() {
        // Do nothing
    }
}