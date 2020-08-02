/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {

    private final SET<Point2D> points;
    // construct an empty set of points
    public PointSET()
    {
        points = new SET<>();
    }

    // is the set empty?
    public boolean isEmpty()
    {
        return points.isEmpty();
    }

    // number of points in the set
    public int size()
    {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p)
    {
        if (p == null)
        {
            throw new IllegalArgumentException();
        }

        if (!contains(p))
        {
            points.add(p);
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p)
    {
        if (p == null)
        {
            throw new IllegalArgumentException();
        }

        return points.contains(p);
    }

    // draw all points to standard draw
    public void draw()
    {
        StdDraw.setPenColor(StdDraw.BLACK);

        for (Point2D p : points)
        {
            StdDraw.point(p.x(), p.y());
        }

        StdDraw.show();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect)
    {
        SET<Point2D> insideRectangle = new SET<>();
        if (rect == null)
        {
            throw new IllegalArgumentException();
        }

        for (Point2D p : points)
        {
            if (rect.contains(p))
            {
                insideRectangle.add(p);
            }
        }

        return insideRectangle;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p)
    {
        if (p == null)
        {
            throw new IllegalArgumentException();
        }

        Point2D nearest = null;
        double minDistance = Double.POSITIVE_INFINITY;

        for (Point2D q : points)
        {
            double currentDistance = p.distanceSquaredTo(q);

            if (currentDistance < minDistance)
            {
                minDistance = currentDistance;
                nearest = q;
            }
        }

        return nearest;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args)
    {
        PointSET set = new PointSET();

        set.insert(new Point2D(0.7, 0.2)); // A
        set.insert(new Point2D(0.5, 0.4)); // B
        set.insert(new Point2D(0.2, 0.3)); // C
        set.insert(new Point2D(0.4, 0.7)); // D
        set.insert(new Point2D(0.9, 0.6)); // E

        set.draw();
    }
}
