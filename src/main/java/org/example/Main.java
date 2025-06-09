package org.example;

import org.example.Turtle.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the SE 350 Turtle Graphics Editor!");

        Matrix matrix = new Matrix(40, 20);
        DrawingStrategy strategy = new BresenhamStrategy(); // Default
        Turtle turtle = new Turtle(matrix, strategy);
        CommandManager manager = new CommandManager();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            } else if (input.equals("show")) {
                matrix.print();
            } else if (input.startsWith("move ")) {
                try {
                    double distance = Double.parseDouble(input.split(" ")[1]);
                    manager.executeCommand(new MoveCommand(turtle, distance));
                } catch (Exception e) {
                    System.out.println("Invalid move command. Usage: move <distance>");
                }
            } else if (input.startsWith("trace ")) {
                try {
                    double distance = Double.parseDouble(input.split(" ")[1]);
                    manager.executeCommand(new TraceCommand(turtle, distance));
                } catch (Exception e) {
                    System.out.println("Invalid trace command. Usage: trace <distance>");
                }
            } else if (input.startsWith("turn ")) {
                try {
                    double angle = Double.parseDouble(input.split(" ")[1]);
                    manager.executeCommand(new TurnCommand(turtle, angle));
                } catch (Exception e) {
                    System.out.println("Invalid turn command. Usage: turn <angle>");
                }
            } else if (input.equals("penup")) {
                manager.executeCommand(new PenUpCommand(turtle));
            } else if (input.equals("pendown")) {
                manager.executeCommand(new PenDownCommand(turtle));
            } else if (input.equals("undo")) {
                manager.undo();
            } else if (input.equals("redo")) {
                manager.redo();
            } else if (input.equals("draw se350")) {
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
            }else if (input.equals("draw se")) {
                manager.executeCommand(new SECommand(turtle));
                matrix.print();
            }else if (input.equals("draw 5")) {
                manager.executeCommand(new FiveCommand(turtle));
                matrix.print();
            } else if (input.equals("draw 0")) {
                manager.executeCommand(new ZeroCommand(turtle));
                matrix.print();
            } else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}
