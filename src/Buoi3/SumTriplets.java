package Buoi3;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class SumTriplets
{
    static void find(int []a)
    {
        boolean found = false;

        Arrays.sort(a); //nlog(n)

        for(int i = 0; i < a.length; i++)
        {
            int l = i + 1;
            int r = a.length - 1;
            int x = a[i];
            while(l < r)
            {
                if(x + a[l] + a[r] == 0)
                {
                    StdOut.println(x + " " + a[l] + " " + a[r]);
                    l++;
                    r--;
                    found = true;
                }

                else if(x + a[l] + a[r] < 0)
                {
                    l++;
                }

                else
                {
                    r--;
                }
            }

        }

        if(!found)
        {
            StdOut.println("No Triplet Found");
        }
    }

    public static void main(String []args)
    {
        In in = new In("D:\\Nam_hai\\Semester_1\\DSA\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();
        find(a);
    }
}
