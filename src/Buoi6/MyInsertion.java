package Buoi6;

import edu.princeton.cs.algs4.*;

import java.io.FileOutputStream;

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
        In random = new In("D:\\Nam_hai\\Semester_1\\DSA\\sort_data\\random.txt");
        In sorted = new In("D:\\Nam_hai\\Semester_1\\DSA\\sort_data\\sorted.txt");
        In sortDescending = new In("D:\\Nam_hai\\Semester_1\\DSA\\sort_data\\sort_descending.txt");
        In sameNumbers = new In("D:\\Nam_hai\\Semester_1\\DSA\\sort_data\\same_numbers.txt");

        int [] randomArray = random.readAllInts();
        int [] sortedArray = random.readAllInts();
        int [] sortDescendingArray = random.readAllInts();
        int [] sameNumbersArray = random.readAllInts();

        Stopwatch randomStopwatch = new Stopwatch();
        MyInsertion.sort(randomArray);
        StdOut.println("Random data: " + randomStopwatch.elapsedTime());

        Stopwatch sortedStopwatch = new Stopwatch();
        MyInsertion.sort(sortedArray);
        StdOut.println("Sorted data: " + sortedStopwatch.elapsedTime());

        Stopwatch sortDescendingStopwatch = new Stopwatch();
        MyInsertion.sort(sortDescendingArray);
        StdOut.println("sortDescending data: " + sortDescendingStopwatch.elapsedTime());

        Stopwatch sameNumbersStopwatch = new Stopwatch();
        MyInsertion.sort(sameNumbersArray);
        StdOut.println("sameNumbers data: " + sameNumbersStopwatch.elapsedTime());
    }
}
