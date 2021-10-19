package Buoi6;

public class QuickSort
{
    public static void swap(int []a,  int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition (int []a, int l, int h)
    {
        int pivot = a[h];

        int i = l - 1; //i = - 1

        for(int j = l; j < h; j++)
        {
            if(a[j] < pivot)
            {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, h);
        return (i + 1);
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
        int []a = {2, 6, 7, 1, 0, 10, 11, 15, 19, 4};
        quickSort(a, 0, a.length - 1);
        print(a);
    }
}
