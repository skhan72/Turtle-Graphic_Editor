package org.example.Turtle;

/**
 * Represents a composite turtle command to draw the letter 'S'.
 * This command uses a sequence of smaller commands to trace out an 'S' shape
 * starting from the current turtle position.
 */
public class SCommand extends CompositeCommand {

    /**
     * Constructs the 'S' drawing command using a turtle.
     *
     * @param turtle the Turtle instance used to execute the drawing commands
     */
    public SCommand(Turtle turtle) {
        super();

        // Put pen down to start drawing
        addCommand(new PenDownCommand(turtle));

        // Draw top horizontal part of S
        addCommand(new TraceCommand(turtle, 5));

        // Turn downwards and draw vertical curve
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, 2));

        // Draw middle horizontal part of S (leftward)
        addCommand(new TurnCommand(turtle, 90));
        addCommand(new TraceCommand(turtle, 5));

        // Draw downward vertical to bottom
        addCommand(new TurnCommand(turtle, -90));
        addCommand(new TraceCommand(turtle, 2));

        // Draw bottom horizontal part of S
        addCommand(new TurnCommand(turtle, -90));
        addCommand(new TraceCommand(turtle, 5));
    }
}
