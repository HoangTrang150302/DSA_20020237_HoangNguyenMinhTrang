package Buoi6;

import edu.princeton.cs.algs4.*;

public class MyInsertion
{
    public static void sort(int []a)
    {
        int n = a.length;
        for(int i = 1; i < n; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if(a[j] < a[j-1])
                {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
                else break;
            }
        }
    }

    public static void main(String[] args)
    {
        In in = new In("D:\\Nam_hai\\Semester_1\\DSA\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        In in1 = new In("D:\\Nam_hai\\Semester_1\\DSA\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        Out out = new Out("D:\\Nam_hai\\Semester_1\\DSA\\sort data\\sorted.txt");
        int [] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        int [] b = in1.readAllInts();  // đọc toàn bộ file vào mảng a
        Stopwatch stopwatch = new Stopwatch();
        MyInsertion.sort(a);
        StdOut.println(stopwatch.elapsedTime());
        StdArrayIO.print(a);

        MyInsertion.sort(b);
        //StdOut.println(stopwatch.elapsedTime());

        StdArrayIO.print(b);
    }
}
