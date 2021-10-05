import java.io.*;
import java.util.HashSet;
import edu.princeton.cs.algs4.*;

class PairSum
{
    static void TwoSum(int []a, int sum)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < a.length; i++)
        {
            int temp = sum - a[i];

            if(s.contains(temp))
            {
               StdOut.println(a[i] + " " + temp);
            }
            s.add(a[i]);
        }
    }

    public static void main(String []args)
    {
        In in = new In("D:\\Nam hai\\Semester 1\\Cau truc du lieu giai thuat\\algs4-data\\2Kints.txt");
        int[] a = in.readAllInts();
        //StdArrayIO.print(a);
        TwoSum(a, 0);
    }
}