package Review;

public class InsertionSort {
    public static void sort(int []a)
    {
        for (int i = 1; i < a.length; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (a[j] < a[j - 1])
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

    public static void swap(int []a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int []a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String []args)
    {
        int []a = {7, 1, 8, 10, 3};
        sort(a);
        print(a);
    }
}
