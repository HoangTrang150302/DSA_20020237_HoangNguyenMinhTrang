package Buoi9;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class ClosestNumber {
    public static void merge(List<Integer> arr, int left, int mid, int right)
    {
        //Find size of two subarrays
        //Subarray 1: left -> mid
        //Subarray 2: mid + 1 -> right
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //Create two subarray
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        //Copy data to subarrays
        for (int i = 0; i < n1; i++)
        {
            leftList.add(arr.get(left + i));
        }
        for (int i = 0; i < n2; i++)
        {
            rightList.add(arr.get(mid + 1 + i));
        }

        //Merge to the original array
        int k = left;
        while(!leftList.isEmpty() && !rightList.isEmpty())
        {
            if(leftList.get(0) < rightList.get(0))
            {
                arr.set(k, leftList.remove(0));
            }
            else
            {
                arr.set(k, rightList.remove(0));
            }
            k++;
        }

        while (!leftList.isEmpty())
        {
            arr.set(k, leftList.remove(0));
            k++;
        }

        while (!rightList.isEmpty())
        {
            arr.set(k, rightList.remove(0));
            k++;
        }
    }

    public static void sort(List<Integer> arr, int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left)/2;

            //sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            //merge the sort halves
            merge(arr, left, mid, right);
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        sort(arr, 0, arr.size() - 1);
        List<Integer> result = new ArrayList<>();

        int min = arr.get(1) - arr.get(0);
        for(int i = 0; i < arr.size() - 1; i++)
        {
            if((arr.get(i + 1) - arr.get(i)) < min)
            {
                min = arr.get(i + 1) - arr.get(i);
            }
        }

        for(int i = 0; i < arr.size() - 1; i++)
        {
            if((arr.get(i + 1) - arr.get(i)) == min)
            {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            }
        }
        return result;
    }

    public static void print(List<Integer> arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);
        numbers.add(5);
        print(numbers);
        sort(numbers, 0, 3);
        print(numbers);
        print(closestNumbers(numbers));
    }
}
