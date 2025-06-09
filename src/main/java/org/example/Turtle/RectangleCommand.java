package org.example.Turtle;

public class RectangleCommand extends CompositeCommand {
    public RectangleCommand(Turtle turtle, double width, double height) {
        super();
        addCommand(new TraceCommand(turtle, width));    // Top edge
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, height));   // Right edge
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, width));    // Bottom edge
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, height));   // Left edge
        addCommand(new TurnCommand(turtle, 90));        // Back to original direction
    }
}
