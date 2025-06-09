package org.example.Turtle;

public class ZeroCommand extends CompositeCommand {
    public ZeroCommand(Turtle turtle) {
        super();

        addCommand(new PenDownCommand(turtle));

        // Top horizontal
        addCommand(new TraceCommand(turtle, 5));
        addCommand(new TurnCommand(turtle, 90));

        // Right vertical
        addCommand(new TraceCommand(turtle, 5));
        addCommand(new TurnCommand(turtle, 90));

        // Bottom horizontal
        addCommand(new TraceCommand(turtle, 5));
        addCommand(new TurnCommand(turtle, 90));

        // Left vertical
        addCommand(new TraceCommand(turtle, 5));

        addCommand(new TurnCommand(turtle, 90)); // Reset orientation
    }
}
