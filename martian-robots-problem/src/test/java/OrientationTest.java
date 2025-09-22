import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testLeftRotation() {
        assertEquals(Orientation.W, Orientation.N.left());
        assertEquals(Orientation.S, Orientation.W.left());
        assertEquals(Orientation.E, Orientation.S.left());
        assertEquals(Orientation.N, Orientation.E.left());
    }

    @Test
    void testRightRotation() {
        assertEquals(Orientation.E, Orientation.N.right());
        assertEquals(Orientation.S, Orientation.E.right());
        assertEquals(Orientation.W, Orientation.S.right());
        assertEquals(Orientation.N, Orientation.W.right());
    }

    @Test
    void testMoveForward() {
        Coordinate start = new Coordinate(2, 2);

        assertEquals(new Coordinate(2, 3), Orientation.N.move(start));
        assertEquals(new Coordinate(2, 1), Orientation.S.move(start));
        assertEquals(new Coordinate(3, 2), Orientation.E.move(start));
        assertEquals(new Coordinate(1, 2), Orientation.W.move(start));
    }
}
