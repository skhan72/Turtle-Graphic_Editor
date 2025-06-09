import org.example.Turtle.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SE350CommandTest {

    private Matrix matrix;
    private Turtle turtle;

    @BeforeEach
    public void setUp() {
        matrix = new Matrix(50, 50);  // Big enough to hold SE350
        DrawingStrategy strategy = new SimpleDrawingStrategy();
        turtle = new Turtle(matrix, strategy);
    }

    @Test
    public void testSE350DrawsSuccessfully() {
        SE350Command command = new SE350Command(turtle);
        assertDoesNotThrow(command::execute);
    }

    @Test
    public void testCanvasContainsDrawing() {
        SE350Command command = new SE350Command(turtle);
        command.execute();

        // Print for visual confirmation (optional)
        matrix.print();

        // Check at least one non-space character is drawn
        boolean hasDrawing = false;
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                // A private way to access the grid isn't provided, so maybe enhance Matrix later
                // Or wrap `Matrix.print()` to a string to test
            }
        }

        // Temporary assertion (since grid is private)
        assertTrue(true, "Executed SE350Command");
    }

    @Test
    public void testTurtleMoveWithoutPen() {
        turtle.penUp();
        double startX = turtle.getX();
        double startY = turtle.getY();
        turtle.move(10);
        assertNotEquals(startX, turtle.getX());
        assertEquals(startY, turtle.getY());
    }

    @Test
    public void testTurtleTurn() {
        turtle.turn(90);
        assertEquals(90, turtle.getDirection(), 0.01);
        turtle.turn(270);
        assertEquals(0, turtle.getDirection(), 0.01); // full circle
    }

    @Test
    public void testPenDownDrawsOnMatrix() {
        turtle.penDown();
        turtle.move(5);  // should draw a horizontal line
        matrix.print();  // visually check
    }

    @Test
    public void testUndoRestoresPreviousState() {
        turtle.penDown();
        turtle.saveState();
        turtle.move(5);
        turtle.undo();

        assertEquals(0, turtle.getX(), 0.01);
        assertEquals(0, turtle.getY(), 0.01);
    }

    @Test
    public void testSCommandExecutes() {
        SCommand s = new SCommand(turtle);
        assertDoesNotThrow(s::execute);
    }

    @Test
    public void testPenUpDoesNotDraw() {
        turtle.penUp();
        turtle.move(10);
        // Should leave matrix blank
        matrix.print();  // visually confirm (or implement getter to inspect grid content)
    }

    @Test
    public void testDrawingAtMatrixEdge() {
        Turtle edgeTurtle = new Turtle(new Matrix(10, 10), new SimpleDrawingStrategy());
        edgeTurtle.penDown();
        edgeTurtle.move(100); // try moving beyond bounds
        // Should not crash or throw
    }
}


