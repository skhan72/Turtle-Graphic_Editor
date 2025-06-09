package org.example.Turtle;

/**
 * Represents a composite turtle command to draw the letter 'E'.
 * This command uses a series of smaller turtle commands to draw
 * the letter 'E' starting from the bottom-left corner.
 */
public class ECommand extends CompositeCommand {

    /**
     * Constructs the 'E' drawing command using a turtle.
     *
     * @param turtle the Turtle instance used to execute the drawing commands
     */
    public ECommand(Turtle turtle) {
        super();

        // 1. Draw bottom row (start at bottom-left, face right)
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 5));

        // 2. Draw left vertical side (face up)
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 180));       // Turn to face left
        addCommand(new MoveCommand(turtle, 5));         // Move back to bottom-left
        addCommand(new TurnCommand(turtle, -90));       // Face upward
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 4));        // Draw vertical line

        // 3. Draw top row (face right)
        addCommand(new TurnCommand(turtle, -90));       // Turn to face right
        addCommand(new TraceCommand(turtle, 4));        // Draw top line

        // 4. Move to middle row
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 180));       // Face left
        addCommand(new MoveCommand(turtle, 5));         // Back to left column
        addCommand(new TurnCommand(turtle, -90));       // Face down
        addCommand(new MoveCommand(turtle, 2));         // Move to middle row
        addCommand(new TurnCommand(turtle, 90));        // Face right
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 4));        // Draw middle row
    }
}

