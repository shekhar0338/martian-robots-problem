import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void testEquality() {
        Coordinate c1 = new Coordinate(1, 1);
        Coordinate c2 = new Coordinate(1, 1);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testDifferentCoordinatesNotEqual() {
        Coordinate c1 = new Coordinate(1, 1);
        Coordinate c2 = new Coordinate(2, 3);

        assertNotEquals(c1, c2);
    }
}
