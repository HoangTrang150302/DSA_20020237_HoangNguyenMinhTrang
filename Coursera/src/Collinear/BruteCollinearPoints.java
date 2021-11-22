import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final ArrayList<LineSegment> collinearPoints;

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        validate(points);
        collinearPoints = new ArrayList<>();
        Point []pointArray = points;
        Arrays.sort(pointArray);

        for (int i = 0; i < pointArray.length; i++)
        {
            for (int j = i + 1; j < pointArray.length; j++)
            {
                for (int k = j + 1; k < pointArray.length; k++)
                {
                    for (int h = k + 1; h < pointArray.length; h++)
                    {
                        if (pointArray[i].slopeTo(pointArray[j]) == pointArray[j].slopeTo(pointArray[k]) &&
                                pointArray[j].slopeTo(pointArray[k]) == pointArray[k].slopeTo(pointArray[h]))
                        {
                            LineSegment lineSegment = new LineSegment(pointArray[i], pointArray[h]);
                            collinearPoints.add(lineSegment);
                        }
                    }
                }
            }
        }
    }

    private void validate(Point[] points)
    {
        if (points == null)
        {
            throw new IllegalArgumentException("Null Array");
        }
        for (int i = 0; i < points.length; i++)
        {
            if (points[i] == null)
            {
                throw new NullPointerException("Null point");
            }
            for (int j = i + 1; j < points.length; j++)
            {
                if (points[j] == null)
                {
                    throw new NullPointerException("Null point");
                }
                if (points[i].compareTo(points[j]) == 0)
                {
                    throw new IllegalArgumentException("Repeated point");
                }
            }
        }
    }

    public int numberOfSegments()        // the number of line segments
    {
        return collinearPoints.size();
    }

    public LineSegment[] segments()                // the line segments
    {
        int n = numberOfSegments();
        LineSegment []lineSegments = new LineSegment[n];
        for (int i = 0; i < n; i++)
        {
            lineSegments[i] = collinearPoints.get(i);
        }
        return lineSegments;
    }

    public static void main(String[] args) {

        // read the n points from a file
        // In in = new In(args[0]);
        In in = new In("D:\\Nam_hai\\Semester_1\\DSA\\DSA_BTVN\\Coursera\\src\\number.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
