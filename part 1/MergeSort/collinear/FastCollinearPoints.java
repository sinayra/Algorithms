/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

    private static final int DELAY = 1000;
    private final ArrayList<LineSegment> lines;

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points)
    {
        if (points == null)
        {
            throw new IllegalArgumentException();
        }

        for (Point p : points)
        {
            if (p == null)
            {
                throw new IllegalArgumentException();
            }
        }

        Point[] copyPoints = points.clone();
        lines = new ArrayList<>();

        for (int i = 1; i < copyPoints.length; i++)
        {
            if (copyPoints[i].compareTo(copyPoints[i - 1]) == 0)
            {
                throw new IllegalArgumentException();
            }
        }

        for (int p = 0; p < copyPoints.length - 3; p++)
        {
            Arrays.sort(copyPoints);
            Point p0 = copyPoints[p];

            // get comparator from point p and sort based on this comparator
            Arrays.sort(copyPoints, p0.slopeOrder());
            for (int q = 1; q < copyPoints.length - 3; q++)
            {
                Point q1 = copyPoints[q];
                Point q2 = copyPoints[q + 1];
                double slopeP0Q1 = p0.slopeTo(q1);
                double slopeP0Q2 = p0.slopeTo(q2);

                if (slopeP0Q1 != slopeP0Q2)
                {
                    continue;
                }
                Point q3 = copyPoints[q + 2];
                double slopeP0Q3 = p0.slopeTo(q3);

                if (slopeP0Q2 == slopeP0Q3)
                {
                    while (q  < copyPoints.length - 4)
                    {
                        Point q4 = copyPoints[q + 3];
                        double slopeP0Q4 = p0.slopeTo(q4);
                        if (slopeP0Q3 == slopeP0Q4)
                        {
                            q++;
                        }
                        else {
                            break;
                        }
                    }
                    q3 = copyPoints[q + 2];

                    // the start point that i want to add is less than the next point
                    if (p0.compareTo(q1) < 0)
                    {
                        lines.add(new LineSegment(p0, q3));
                    }

                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments()
    {
        return lines.size();
    }

    // the line segments
    public LineSegment[] segments()
    {
        return lines.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++)
        {
            int x = in.readInt();
            int y = in.readInt();

            points[i] = new Point(x, y);
        }

        FastCollinearPoints collinear = new FastCollinearPoints(points);

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenRadius(0.03);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        for (Point p : points) {
            p.draw();
            //StdDraw.show();
            //StdDraw.pause(DELAY);
        }

        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLACK);
        for (LineSegment line : collinear.segments())
        {
            line.draw();
            //StdDraw.show();
            //StdDraw.pause(DELAY);
        }

        StdDraw.show();
    }
}