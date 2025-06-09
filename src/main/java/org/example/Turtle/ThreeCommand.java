package org.example.Turtle;

public class ThreeCommand extends CompositeCommand {
    public ThreeCommand(Turtle turtle) {
        super();

        // Bottom horizontal bar
        addCommand(new PenDownCommand(turtle));
        addCommand(new TraceCommand(turtle, 5));  // -----

        // Lower right vertical
        addCommand(new TurnCommand(turtle, 90));  // face up
        addCommand(new TraceCommand(turtle, 2));  // |

        // Middle bar
        addCommand(new TurnCommand(turtle, 90));  // face left-to-right
        addCommand(new TraceCommand(turtle, 5));  // -----

        // Upper right vertical
        addCommand(new TurnCommand(turtle, -90)); // face up
        addCommand(new TraceCommand(turtle, 2));  // |

        // Top bar
        addCommand(new TurnCommand(turtle, 90));  // face right
        addCommand(new TraceCommand(turtle, 5));  // -----

        // Done, lift pen to prepare for move
        addCommand(new PenUpCommand(turtle));
    }
}
