package org.example.Turtle;

public class QuitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    @Override
    public void undo() {
        // No-op
    }
}