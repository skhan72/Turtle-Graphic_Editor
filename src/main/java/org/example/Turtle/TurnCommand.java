package org.example.Turtle;

public class TurnCommand implements Command {
    private final Turtle turtle;
    private final double angle;

    public TurnCommand(Turtle turtle, double angle) {
        this.turtle = turtle;
        this.angle = angle;
    }

    @Override
    public void execute() {
        turtle.saveState();         // Save before turning
        turtle.turn(angle);
    }

    @Override
    public void undo() {
        turtle.undo();              // Restore
    }
}

