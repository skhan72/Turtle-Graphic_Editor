package org.example.Turtle;

public class ECommand extends CompositeCommand {
    public ECommand(Turtle turtle) {
        super();

        // 1. Draw bottom row (start at bottom-left, face right)
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 5));

        // 2. Draw left vertical (face up)
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 180));       // face left
        addCommand(new MoveCommand(turtle, 5));         // back to bottom-left
        addCommand(new TurnCommand(turtle, -90));       // face up
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 4));        // draw vertical

        // 3. Draw top row
        addCommand(new TurnCommand(turtle, -90));       // face right
        addCommand(new TraceCommand(turtle, 4));

        // 4. Draw middle row
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 180));       // face left
        addCommand(new MoveCommand(turtle, 5));         // back to col 0
        addCommand(new TurnCommand(turtle, -90));       // face down
        addCommand(new MoveCommand(turtle, 2));         // to middle row
        addCommand(new TurnCommand(turtle, 90));        // face right
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 4));        // middle row
    }
}
