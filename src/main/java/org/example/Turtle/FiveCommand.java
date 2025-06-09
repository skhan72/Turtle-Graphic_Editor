package org.example.Turtle;

public class FiveCommand extends CompositeCommand {
    public FiveCommand(Turtle turtle) {
        super();

        addCommand(new PenDownCommand(turtle));

        // Top horizontal
        addCommand(new TraceCommand(turtle, 5));

        // Right-down
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, 2));

        // Middle horizontal (left)
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, 5));

        // Left-down
        addCommand(new TurnCommand(turtle, -90));
        addCommand(new TraceCommand(turtle, 2));

        // Bottom horizontal (right)
        addCommand(new TurnCommand(turtle, -90));
        addCommand(new TraceCommand(turtle, 5));
    }
}

