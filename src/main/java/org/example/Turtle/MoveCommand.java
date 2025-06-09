package org.example.Turtle;

public class MoveCommand implements Command {
    private final Turtle turtle;
    private final double distance;

    public MoveCommand(Turtle turtle, double distance) {
        this.turtle = turtle;
        this.distance = distance;
    }

    @Override
    public void execute() {
        turtle.saveState();
        turtle.move(distance);
    }

    @Override
    public void undo() {
        turtle.undo();
    }
}
