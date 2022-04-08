package Review;

public class QuickSort {
    public static void swap(int []a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int []a, int low, int high)
    {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++)
        {
            if (a[j] < pivot)
            {
                i++;
                swap(a, j, i);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    public static void quickSort(int []a, int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot, high);
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
