import edu.princeton.cs.algs4.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
class KdTreeTest {

    @org.junit.jupiter.api.Test
    void contains() {
        KdTree kdTree = new KdTree();

        kdTree.insert(new Point2D(0.7, 0.2)); // A
        kdTree.insert(new Point2D(0.5, 0.4)); // B
        kdTree.insert(new Point2D(0.2, 0.3)); // C
        kdTree.insert(new Point2D(0.4, 0.7)); // D
        kdTree.insert(new Point2D(0.9, 0.6)); // E

        assertTrue(kdTree.contains(new Point2D(0.2, 0.3)));
    }
}