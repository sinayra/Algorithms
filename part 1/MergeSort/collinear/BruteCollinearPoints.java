/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private static final int DELAY = 1000;
    private final ArrayList<LineSegment> lines;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points)
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

        Arrays.sort(copyPoints);
        lines = new ArrayList<>();

        for (int i = 1; i < copyPoints.length; i++)
        {
            if (copyPoints[i].compareTo(copyPoints[i - 1]) == 0)
            {
                throw new IllegalArgumentException();
            }
        }

        for (int p = 0; p < copyPoints.length; p++)
        {
            for (int q = p + 1; q < copyPoints.length; q++)
            {
                double slopePQ = copyPoints[p].slopeTo(copyPoints[q]);
                for (int r = q + 1; r < copyPoints.length; r++)
                {
                    double slopePR = copyPoints[p].slopeTo(copyPoints[r]);

                    if (slopePQ != slopePR)
                    {
                        continue;
                    }
                    for (int s = r + 1; s < points.length; s++) {
                        double slopePS = copyPoints[p].slopeTo(copyPoints[s]);

                        if (slopePR == slopePS)
                        {
                            lines.add(new LineSegment(copyPoints[p], copyPoints[s]));
                        }
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

        BruteCollinearPoints collinear = new BruteCollinearPoints(points);

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
