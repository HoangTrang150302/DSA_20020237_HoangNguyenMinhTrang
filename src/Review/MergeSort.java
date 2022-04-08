package Review;

public class MergeSort {
    public static void merge(int []a, int low, int mid, int high)
    {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int []leftArray = new int[leftSize];
        int []rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
        {
            leftArray[i] = a[low + i];
        }

        for (int j = 0; j < rightSize; j++)
        {
            rightArray[j] = a[j + mid + 1];
        }

        //merge
        int i = 0, j = 0, k = low;
        while(i < leftSize && j < rightSize)
        {
            if (leftArray[i] < rightArray[j])
            {
                a[k] = leftArray[i];
                i++;
                k++;
            }
            else
            {
                a[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftSize)
        {
            a[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize)
        {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int []a, int low, int high)
    {
        if (low < high)
        {
            int mid = low + (high - low) / 2;

            sort(a, low, mid);
            sort(a, mid + 1, high);

            merge(a, low, mid, high);
        }
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
        sort(a, 0, a.length - 1);
        print(a);
    }
}
