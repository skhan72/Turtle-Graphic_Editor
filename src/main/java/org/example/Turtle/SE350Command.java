package org.example.Turtle;

public class SE350Command extends CompositeCommand {
    public SE350Command(Turtle turtle) {
        super();

        // Draw S
        addCommand(new SCommand(turtle));

        // Move to next letter position
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 90));   // face right
        addCommand(new MoveCommand(turtle, 7));    // move 7 units for space (5 width + 2 space)
        addCommand(new TurnCommand(turtle, -90));  // face original direction (up)

        // Draw E
        addCommand(new ECommand(turtle));

        // Move to next letter position
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 90));   // face right
        addCommand(new MoveCommand(turtle, 7));
        addCommand(new TurnCommand(turtle, -90));  // face original direction

        // Draw 3
        addCommand(new ThreeCommand(turtle));

        // Move to next letter position
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 90));   // face right
        addCommand(new MoveCommand(turtle, 7));
        addCommand(new TurnCommand(turtle, -90));  // face original direction

        // Draw 5
        addCommand(new FiveCommand(turtle));

        // Move to next letter position
        addCommand(new PenUpCommand(turtle));
        addCommand(new TurnCommand(turtle, 90));   // face right
        addCommand(new MoveCommand(turtle, 7));
        addCommand(new TurnCommand(turtle, -90));  // face original direction

        // Draw 0
        addCommand(new ZeroCommand(turtle));
    }
}
