package Buoi7;

import java.util.Scanner;

public class QuickSortInPlace {
    public static void swap(int []a,  int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition (int []a, int l, int h)
    {
        int pivot = a[h];

        int i = l;

        for(int j = l; j < h; j++)
        {
            if(a[j] < pivot)
            {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, h);
        print(a);
        return i; //pivot position
    }

    public static void quickSort(int []a, int l, int h)
    {
        if(l < h)
        {
            int pi = partition(a, l, h);
            quickSort(a, l, pi - 1);
            quickSort(a, pi + 1, h);
        }
    }

    public static void print(int []a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, a.length - 1);
    }
}
