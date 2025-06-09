package org.example;

import org.example.Turtle.*;

import java.util.Scanner;

/**
 * Entry point for the SE 350 Turtle Graphics Editor.
 * Supports command-line interface to control a Turtle that draws
 * characters and shapes using drawing commands.
 */
public class Main {
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Welcome to the SE 350 Turtle Graphics Editor!");

        // Create a 40x20 character matrix to draw on
        Matrix matrix = new Matrix(40, 20);

        // Use Bresenham's line drawing algorithm by default
        DrawingStrategy strategy = new BresenhamStrategy();

        // Create a turtle to move around and draw on the matrix
        Turtle turtle = new Turtle(matrix, strategy);

        // Command manager handles execution, undo, and redo of commands
        CommandManager manager = new CommandManager();

        Scanner scanner = new Scanner(System.in);
        String input;

        // Command loop: reads user input until "quit" is entered
        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                // Exit the application
                System.out.println("Goodbye!");
                break;
            } else if (input.equals("show")) {
                // Display current matrix drawing
                matrix.print();
            } else if (input.startsWith("move ")) {
                // Move turtle without drawing
                try {
                    double distance = Double.parseDouble(input.split(" ")[1]);
                    manager.executeCommand(new MoveCommand(turtle, distance));
                } catch (Exception e) {
                    System.out.println("Invalid move command. Usage: move <distance>");
                }
            } else if (input.startsWith("trace ")) {
                // Move turtle and draw as it moves
                try {
                    double distance = Double.parseDouble(input.split(" ")[1]);
                    manager.executeCommand(new TraceCommand(turtle, distance));
                } catch (Exception e) {
                    System.out.println("Invalid trace command. Usage: trace <distance>");
                }
            } else if (input.startsWith("turn ")) {
                // Turn the turtle by a certain angle
                try {
                    double angle = Double.parseDouble(input.split(" ")[1]);
                    manager.executeCommand(new TurnCommand(turtle, angle));
                } catch (Exception e) {
                    System.out.println("Invalid turn command. Usage: turn <angle>");
                }
            } else if (input.equals("penup")) {
                // Lift the pen so movement doesn't draw
                manager.executeCommand(new PenUpCommand(turtle));
            } else if (input.equals("pendown")) {
                // Lower the pen to enable drawing
                manager.executeCommand(new PenDownCommand(turtle));
            } else if (input.equals("undo")) {
                // Undo the last command
                manager.undo();
            } else if (input.equals("redo")) {
                // Redo the previously undone command
                manager.redo();
            } else if (input.equals("draw se350")) {
                // Composite command: draw the full SE350 logo
                manager.executeCommand(new SE350Command(turtle));
                matrix.print();
            } else if (input.equals("draw s")) {
                manager.executeCommand(new SCommand(turtle));
                matrix.print();
            } else if (input.equals("draw e")) {
                manager.executeCommand(new ECommand(turtle));
                matrix.print();
            } else if (input.equals("draw 3")) {
                manager.executeCommand(new ThreeCommand(turtle));
                matrix.print();
            } else if (input.equals("draw se")) {
                manager.executeCommand(new SECommand(turtle));
                matrix.print();
            } else if (input.equals("draw 5")) {
                manager.executeCommand(new FiveCommand(turtle));
                matrix.print();
            } else if (input.equals("draw 0")) {
                manager.executeCommand(new ZeroCommand(turtle));
                matrix.print();
            } else {
                // If input doesn't match any known command
                System.out.println("Unknown command.");
            }
        }

        // Close input scanner to free resources
        scanner.close();
    }
}
