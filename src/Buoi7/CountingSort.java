package Buoi7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(result);
        for (int i = 0; i < 100; i++)
        {
            result.add(0);
        }

        for (int i = 0; i < arr.size(); i++)
        {
            int count = result.get(arr.get(i));
            count++;
            result.set(arr.get(i), count);
        }
        return result;
    }
}
