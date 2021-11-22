import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Test {
    public static void print(Point []points)
    {
        for (int i = 0; i < points.length; i++)
        {
            System.out.print(points[i] + " ");
        }
        System.out.println();
    }

    public static void sort(Point []a, int index)
    {
        swap(a, index, 0);
        for (int i = 1; i < a.length; i++)
        {
            for (int j = i; j > 1; j--)
            {
                if (a[j].slopeTo(a[0]) < a[j - 1].slopeTo(a[0]))
                {
                    swap(a, j, j - 1);
                }
                else
                {
                    break;
                }
            }
        }
    }

    public static void swap(Point []a, int i, int j)
    {
        Point temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String []args)
    {
        In in = new In("D:\\Nam_hai\\Semester_1\\DSA\\DSA_BTVN\\Coursera\\src\\number.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        for (int i = 0; i < n; i++)
        {
            sort(points, i);
            //Arrays.sort(points, points[i].slopeOrder()); //oher point compare with points[i] bt slope
            print(points);
        }
    }
}
