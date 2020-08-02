/* *****************************************************************************
 *  Name:              Sinayra Pascoal Cotts Moreira
 *  Coursera User ID:  9743e5f26c97c13124131a7a0c02a87b
 *  Coursera course:   Algorithms Part 1
 **************************************************************************** */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class KdTree {

    private class Node
    {
        Point2D point;
        Node left;
        Node right;
        Node parent;

        double xmin, ymin, xmax, ymax;

        Node(Point2D p, Node parent)
        {
            this.point = p;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }

        void setRect(double rectXmin, double rectYmin, double rectXmax, double rectYmax)
        {
            this.xmin = rectXmin;
            this.ymin = rectYmin;
            this.xmax = rectXmax;
            this.ymax = rectYmax;
        }
    }

    private Node root;
    private int size;

    // construct an empty set of points
    public KdTree()
    {
        root = null;
    }

    // is the set empty?
    public boolean isEmpty()
    {
        return root == null;
    }

    // number of points in the set
    public int size()
    {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p)
    {
        if (p == null)
        {
            throw new IllegalArgumentException();
        }

        if (isEmpty())
        {
            root = new Node(p, null);
            root.setRect(0, 0, 1, 1);
            size++;
        }
        else
        {
            Node leaf = root;
            Node previous = null;
            boolean checkCoordX = true;

            while (leaf != null && !leaf.point.equals(p))
            {
                previous = leaf;
                if (checkCoordX)
                {
                    if (p.x() < leaf.point.x())
                    {
                        leaf = leaf.left;
                    }
                    else
                    {
                        leaf = leaf.right;
                    }
                }
                else
                {
                    if (p.y() < leaf.point.y())
                    {
                        leaf = leaf.left;
                    }
                    else
                    {
                        leaf = leaf.right;
                    }
                }

                checkCoordX = !checkCoordX;
            }

            // this point does not exists in the set
            if (leaf == null)
            {
                size++;
                // revert check to last iteration
                checkCoordX = !checkCoordX;

                if (checkCoordX)
                {
                    if (p.x() < previous.point.x())
                    {
                        previous.left = new Node(p, previous);
                        previous.left.setRect(previous.xmin, previous.ymin, previous.point.x(), previous.ymax);
                    }
                    else
                    {
                        previous.right = new Node(p, previous);
                        previous.right.setRect(previous.point.x(), previous.ymin, previous.xmax, previous.ymax);
                    }
                }
                else
                {
                    if (p.y() < previous.point.y())
                    {
                        previous.left = new Node(p, previous);
                        previous.left.setRect(previous.xmin, previous.ymin, previous.xmax, previous.point.y());
                    }
                    else
                    {
                        previous.right = new Node(p, previous);
                        previous.right.setRect(previous.xmin, previous.point.y(), previous.xmax, previous.ymax);
                    }
                }
            }
        }


    }

    // does the set contain point p?
    public boolean contains(Point2D p)
    {
        if (p == null)
        {
            throw new IllegalArgumentException();
        }


        boolean isVertical = true;
        Node leaf = root;
        while (leaf != null)
        {
            if (p.equals(leaf.point))
            {
                return true;
            }

            if (isVertical)
            {
                if (p.x() < leaf.point.x())
                {
                    leaf = leaf.left;
                }
                else
                {
                    leaf = leaf.right;
                }
            }
            else
            {
                if (p.y() < leaf.point.y())
                {
                    leaf = leaf.left;
                }
                else
                {
                    leaf = leaf.right;
                }
            }

            isVertical = !isVertical;
        }

        return  false;
    }

    // draw all points to standard draw
    public void draw()
    {
        // draw root
        if (!isEmpty())
        {
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(root.point.x(), root.point.y());

            StdDraw.setPenColor(StdDraw.RED);
             double x0 = root.point.x();
             double y0 = 0;

             double x1 = root.point.x();
             double y1 = 1;

            StdDraw.setPenRadius();
            StdDraw.line(x0, y0, x1, y1);
        }


        drawRecursive(root.left, false, true);
        drawRecursive(root.right, false, false);

        StdDraw.show();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect)
    {
        List<Point2D> insideRectangle = new ArrayList<>();
        if (rect == null)
        {
            throw new IllegalArgumentException();
        }

        if (rect.contains(root.point))
        {
            insideRectangle.add(root.point);
        }

        RectHV leftRectangle = new RectHV(0, 0, root.point.x(), 1);
        RectHV rightRectangle = new RectHV(root.point.x(), 0, 1, 1);

        if (rect.intersects(leftRectangle))
        {
            searchSubTree(rect, root.left, insideRectangle, false);
        }

        if (rect.intersects(rightRectangle))
        {
            searchSubTree(rect, root.right, insideRectangle, false);
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

        if (isEmpty())
        {
            return null;
        }

        double currentDistance = p.distanceSquaredTo(root.point);

        RectHV leftRectangle = new RectHV(0, 0, root.point.x(), 1);
        RectHV rightRectangle = new RectHV(root.point.x(), 0, 1, 1);

        // get closest distance from any point from left and right rectangle
        double leftSideDistance = leftRectangle.distanceSquaredTo(p);
        double rightSideDistance = rightRectangle.distanceSquaredTo(p);

        if (currentDistance < leftSideDistance && currentDistance < rightSideDistance)
        {
            return root.point;
        }
        else
        {
            Point2D child = null;
            if (leftSideDistance < rightSideDistance)
            {
                child = nearestPointInSubtree(root.left, p, false);

            }
            else
            {
                child = nearestPointInSubtree(root.right, p, false);
            }

            if (child != null)
            {
                double distanceChild = p.distanceSquaredTo(child);
                return distanceChild < currentDistance ? child : root.point;
            }
            return root.point;

        }

    }

    // unit testing of the methods (optional)
    public static void main(String[] args)
    {
        KdTree kdTree = new KdTree();
        Point2D p = new Point2D(0.8, 0.7);

        kdTree.insert(new Point2D(0.206107, 0.095492)); // A
        kdTree.insert(new Point2D(0.975528, 0.654508)); // B
        kdTree.insert(new Point2D(0.024472, 0.345492)); // C
        kdTree.insert(new Point2D(0.793893, 0.095492)); // D
        kdTree.insert(new Point2D(0.793893, 0.904508)); // E
        kdTree.insert(new Point2D(0.975528, 0.345492)); // F
        kdTree.insert(new Point2D(0.206107, 0.904508)); // G
        kdTree.insert(new Point2D(0.500000, 0.000000)); // H
        kdTree.insert(new Point2D(0.024472, 0.654508)); // I
        kdTree.insert(new Point2D(0.500000, 1.000000)); // J

        kdTree.draw();

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.point(p.x(), p.y());
        StdDraw.show();

        Point2D q = kdTree.nearest(p);

        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.setPenRadius();
        StdDraw.line(p.x(), p.y(), q.x(), q.y());

        StdDraw.show();
    }

    private void drawRecursive(Node leaf, boolean isVertical, boolean isLeft)
    {
        if (leaf != null)
        {
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(leaf.point.x(), leaf.point.y());

            double x0, x1, y0, y1;
            if (isVertical)
            {
                // create lines
                StdDraw.setPenColor(StdDraw.RED);
                x0 = leaf.point.x();
                x1 = leaf.point.x();

                if (isLeft)
                {
                    y0 = leaf.ymin;
                    y1 = leaf.parent.point.y();
                }
                else
                {
                    y0 = leaf.parent.point.y();
                    y1 = leaf.ymax;
                }
            }
            else
            {
                StdDraw.setPenColor(StdDraw.BLUE);
                y0 = leaf.point.y();
                y1 = leaf.point.y();

                if (isLeft)
                {
                    x0 = leaf.xmin;
                    x1 = leaf.parent.point.x();
                }
                else
                {
                    x0 = leaf.parent.point.x();
                    x1 = leaf.xmax;
                }
            }

            StdDraw.setPenRadius();
            StdDraw.line(x0, y0, x1, y1);

            drawRecursive(leaf.left, !isVertical, true);
            drawRecursive(leaf.right, !isVertical, false);
        }

    }

    private void searchSubTree(RectHV rect, Node leaf, List<Point2D> insideRectangle, boolean isVertical)
    {
        if (leaf != null)
        {
            if (rect.contains(leaf.point))
            {
                insideRectangle.add(leaf.point);
            }

            RectHV leftRectangle = null, rightRectangle = null;

            // creates rectangles
            if (isVertical)
            {
                leftRectangle = new RectHV(leaf.xmin, leaf.ymin, leaf.point.x(), leaf.ymax);
                rightRectangle = new RectHV(leaf.point.x(), leaf.ymin, leaf.xmax, leaf.ymax);
            }
            else
            {
                leftRectangle = new RectHV(leaf.xmin, leaf.ymin, leaf.xmax, leaf.point.y());
                rightRectangle = new RectHV(leaf.xmin, leaf.point.y(), leaf.xmax, leaf.ymax);
            }

            if (rect.intersects(leftRectangle))
            {
                searchSubTree(rect, leaf.left, insideRectangle, !isVertical);
            }

            if (rect.intersects(rightRectangle))
            {
                searchSubTree(rect, leaf.right, insideRectangle, !isVertical);
            }

        }
    }

    private Point2D nearestPointInSubtree(Node leaf, Point2D p, boolean isVertical)
    {
        if (leaf != null)
        {
            double currentDistance = p.distanceSquaredTo(leaf.point);

            RectHV leftRectangle, rightRectangle;

            if (isVertical)
            {
                leftRectangle = new RectHV(leaf.xmin, leaf.ymin, leaf.point.x(), leaf.ymax);
                rightRectangle = new RectHV(leaf.point.x(), leaf.ymin, leaf.xmax, leaf.ymax);

            }
            else
            {
                leftRectangle = new RectHV(leaf.xmin, leaf.ymin, leaf.xmax, leaf.point.y());
                rightRectangle = new RectHV(leaf.xmin, leaf.point.y(), leaf.xmax, leaf.ymax);
            }

            double leftSideDistance = leftRectangle.distanceSquaredTo(p);
            double rightSideDistance = rightRectangle.distanceSquaredTo(p);

            if (currentDistance < leftSideDistance && currentDistance < rightSideDistance)
            {
                return leaf.point;
            }
            else
            {
                Point2D child = null;
                if (leftSideDistance < rightSideDistance)
                {
                    child = nearestPointInSubtree(leaf.left, p, !isVertical);
                }
                else
                {
                    child = nearestPointInSubtree(leaf.right, p, !isVertical);
                }

                if (child != null)
                {
                    double distanceChild = p.distanceSquaredTo(child);
                    return distanceChild < currentDistance ? child : leaf.point;
                }
                return leaf.point;
            }
        }

        return null;

    }
}
