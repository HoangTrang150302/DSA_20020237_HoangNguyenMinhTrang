package Buoi7;

import java.util.List;

public class BinarySearch {
    public static int introTutorial(int V, List<Integer> arr) {
        int first = 0;
        int last = arr.size() - 1;
        int middle;

        while(first <= last)
        {
            middle = first - (first - last)/2;
            if(arr.get(middle) == V)
            {
                return middle;
            }
            else if(arr.get(middle) < V)
            {
                first = middle + 1;
            }
            else
            {
                last = middle - 1;
            }
        }
        return -1;
    }
}
