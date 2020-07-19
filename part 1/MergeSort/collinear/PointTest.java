import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
class PointTest {

    @org.junit.jupiter.api.Test
    void slopeTo() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);
        Point p4 = new Point(1, 1);
        Point p5 = new Point(2, 5);

        assertEquals(Double.POSITIVE_INFINITY, p1.slopeTo(p2));
        assertEquals(0, p1.slopeTo(p3));
        assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(p4));
        assertEquals(4.0, p1.slopeTo(p5));
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);
        Point p4 = new Point(1, 1);
        Point p5 = new Point(-1, 1);
        Point p6 = new Point(-1, -5);

        assertEquals(0, p1.compareTo(p4));
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(-1, p1.compareTo(p3));
        assertEquals(1, p1.compareTo(p5));
        assertEquals(1, p1.compareTo(p6));
    }

    @org.junit.jupiter.api.Test
    void slopeOrder() {
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Point> ordered = new ArrayList<>();

        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);
        Point p4 = new Point(1, 1);
        Point p5 = new Point(-1, 1);
        Point p6 = new Point(-1, -5);
        Point p7 = new Point(2, 5);

        list.add(p4);
        list.add(p6);
        list.add(p2);
        list.add(p7);
        list.add(p1);
        list.add(p5);
        list.add(p3);

        ordered.add(p6);
        ordered.add(p5);
        ordered.add(p4);
        ordered.add(p1);
        ordered.add(p3);
        ordered.add(p2);
        ordered.add(p7);

        Collections.sort(list);

        assertEquals(ordered, list);
    }
}