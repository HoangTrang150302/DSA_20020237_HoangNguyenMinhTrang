package Buoi7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partition {
    public static void print(List<Integer> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        int pivot = arr.get(0);
        int i = 0; //pivot position
        int l = i + 1;
        int h = arr.size() - 1;

        while(l <= h)
        {
            if(arr.get(l) < pivot)
            {
                Collections.swap(arr, l, i);
                i++;
                l = i + 1;
            }
            else
            {
                Collections.swap(arr, l, h);
                h--;
            }

            //print(arr);
        }

        result.addAll(arr);
        return result;
    }
}
