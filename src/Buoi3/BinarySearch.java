package Buoi3;

import java.util.Random;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class BinarySearch
{
    public static int binarySearch(int []a, int number)
    {
        int first = 0;
        int last = a.length - 1;
        int middle;
        int position = -1;
        while(first <= last)
        {
            middle = (first - last)/2 + last;
            if(a[middle] == number)
            {
                return middle;
            }
            else if(a[middle] > number)
            {
                last = middle - 1;
            }
            else
            {
                first = middle + 1;
            }
        }
        return position;
    }

    public static void main(String [] args)
    {
        Random rd = new Random();
        int []a = new int[1000];
        int []b = {1, 2, 3, 4, 5};
        for(int i = 0; i < a.length; i++)
        {
            a[i] = rd.nextInt();
        }
        Stopwatch timer = new Stopwatch();
        Arrays.sort(a);
        int n = binarySearch(a,7889);
        int m = binarySearch(b,5);
        System.out.println(m);
        System.out.println(n);
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
