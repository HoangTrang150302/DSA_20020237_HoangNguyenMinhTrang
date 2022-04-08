package Collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments = new ArrayList<>();

    public FastCollinearPoints(Point[] points)
    {
        validate(points);
        Point []pointArray = points.clone();
        Arrays.sort(pointArray);

        for (int i = 0; i < pointArray.length - 3; i++) {
            Arrays.sort(pointArray);
            Arrays.sort(pointArray, pointArray[i].slopeOrder());

            for (int p = 0, first = 1, last = 2; last < pointArray.length; last++)
            {
                while (last < pointArray.length
                        && Double.compare(pointArray[p].slopeTo(pointArray[first]),
                        pointArray[p].slopeTo(pointArray[last])) == 0)
                {
                    last++;
                }

                if (last - first >= 3 && pointArray[p].compareTo(pointArray[first]) < 0)
                {
                    segments.add(new LineSegment(pointArray[p], pointArray[last - 1]));
                }

                first = last;
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    private void validate(Point[] points)
    {
        if (points == null)
        {
            throw new NullPointerException("Null Array");
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
