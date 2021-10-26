package Buoi7;

import java.util.Scanner;

class Median
{
    public static void swap(int []a,  int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int []a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static int partition (int []a)
    {
        int h = a.length - 1;
        int l = 0;
        int medianPosition = (a.length - 1)/2;
        int i = 0;

        while (i != medianPosition)
        {
            i = l;
            int pivot = a[h];
            for(int j = l; j < h; j++)
            {
                if(a[j] < pivot)
                {
                    swap(a, i, j);
                    i++;
                }
            }
            swap(a, i, h);
            if(i > medianPosition)
            {
                h--;
            }
            else if(i < medianPosition)
            {
                l++;
            }
        }

        return a[i]; //pivot position
    }

    public static void main(String []args)
    {
        int n = 7;
        int []a = { 12, 3, 5, 7, 4, 19, 26 };
        System.out.println(partition(a));
    }
}

