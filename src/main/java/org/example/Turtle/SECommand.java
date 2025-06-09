package org.example.Turtle;

public class SECommand extends CompositeCommand {
    public SECommand(Turtle turtle) {
        super();

        // Draw 'S'
        addCommand(new PenDownCommand(turtle));
        addCommand(new SCommand(turtle));

        // Move to position for 'E'
        addCommand(new PenUpCommand(turtle));

        // Face right
        addCommand(new TurnCommand(turtle, 90));

        // Move right (give 2 units space after 'S' which is 5 units wide)
        addCommand(new MoveCommand(turtle, 7));

        // Face up (default for E)
        addCommand(new TurnCommand(turtle, -90));

        addCommand(new PenDownCommand(turtle));
        addCommand(new ECommand(turtle));
    }
}
