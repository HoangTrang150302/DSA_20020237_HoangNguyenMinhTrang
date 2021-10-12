package Buoi5;

public class SelectionSort
{
    public static void sort(int []a)
    {
        for(int i = 0; i < a.length; i++)
        {
            int min = a[i];
            int position = i;
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[j] < min)
                {
                    min = a[j];
                    position = j;
                }
            }
            int temp = a[i];
            a[i] = a[position];
            a[position] = temp;
        }
    }

    public static void print(int []a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String []args)
    {
        int []a = {5, 2, 1, 4, 3};
        sort(a);
        print(a);
    }
}
