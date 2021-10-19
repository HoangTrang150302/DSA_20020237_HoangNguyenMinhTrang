<<<<<<< HEAD
package Buoi6;

public class MergeSort
{
    public static void merge(int []a, int l, int m, int r) //left, mid, right
    {
        //Find size of two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create new array
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //copy data to temp array
        for(int i = 0; i < n1; i++)
        {
            leftArray[i] = a[l + i];
        }
        for(int j = 0; j < n2; j++)
        {
            rightArray[j] = a[m + 1 + j];
        }

        //initial index of two subarray
        int i = 0, j = 0;

        //Initial index of array merge two subarray
        int k = l;
        while(i < n1 && j < n2)
        {
            if(leftArray[i] <= rightArray[j])
            {
                a[k] = leftArray[i];
                i++;
            }
            else
            {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //copy the remaining element if any
        while(i < n1)
        {
            a[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2)
        {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int []a, int l, int r)
    {
        if(l < r)
        {
            //find the middle point
            int m = l + (r - l)/2;

            //sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);

            //merge the sort halves
            merge(a, l, m, r);
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
        sort(a, 0, a.length - 1);
        print(a);
    }
}
=======
package Buoi6;

public class MergeSort
{
    public static void merge(int []a, int l, int m, int r) //left, mid, right
    {
        //Find size of two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create new array
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //copy data to temp array
        for(int i = 0; i < n1; i++)
        {
            leftArray[i] = a[l + i];
        }
        for(int j = 0; j < n2; j++)
        {
            rightArray[j] = a[m + 1 + j];
        }

        //initial index of two subarray
        int i = 0, j = 0;

        //Initial index of array merge two subarray
        int k = l;
        while(i < n1 && j < n2)
        {
            if(leftArray[i] <= rightArray[j])
            {
                a[k] = leftArray[i];
                i++;
            }
            else
            {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //copy the remaining element if any
        while(i < n1)
        {
            a[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2)
        {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int []a, int l, int r)
    {
        if(l < r)
        {
            //find the middle point
            int m = l + (r - l)/2;

            //sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);

            //merge the sort halves
            merge(a, l, m, r);
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
        sort(a, 0, a.length - 1);
        print(a);
    }
}
>>>>>>> 1bab2d5926c11f1413f766d3475a761c3b495f58
