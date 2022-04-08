package Buoi8;

public class HeapSort {
    public void Heapify(int []arr, int n, int i)
    {
        int largest = i; //initialize largest as root
        int l = i * 2 + 1; //left
        int r = i * 2 + 2; //right

        //If left child is larger than root
        if ((l < n) && arr[l] > arr[largest])
        {
            largest = l;
        }

        //If right child is larger than root
        if ((r < n) && arr[r] > arr[largest])
        {
            largest = r;
        }

        //If largest is not root, swap root with largest
        if (largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            Heapify(arr, n ,largest);
        }
    }

    public void sort(int []arr)
    {
        int n = arr.length;

        //Build heap (rearrange array), start with the node with the last leaf
        for (int i = n/2 - 1; i >= 0; i--)
        {
            Heapify(arr, n, i);
        }

        //One by one extract an element from heap
        for (int i = n - 1; i > 0; i--)
        {
            //Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //call max heapify on the reduced heap
            Heapify(arr, i, 0);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
