package Buoi11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class MissingNumber2 {
    public static Hashtable<Integer, Integer> addAll(List<Integer> arr)
    {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < arr.size(); i++)
        {
            if (!hashtable.containsKey(arr.get(i)))
            {
                hashtable.put(arr.get(i), 1);
            }
            else
            {
                int frequency = hashtable.get(arr.get(i));
                hashtable.replace(arr.get(i), frequency + 1);
            }
        }
        return hashtable;
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Hashtable<Integer, Integer> hashtable1 = new Hashtable<>();
        Hashtable<Integer, Integer> hashtable2 = new Hashtable<>();
        hashtable1 = addAll(arr);
        hashtable2 = addAll(brr);
        List<Integer> result = new ArrayList<>();


        for (Integer key : hashtable2.keySet()) {
            if (!hashtable1.containsKey(key)) // a khong chua gia tri co trong b
            {
                result.add(key);
            } else {
                // tan so gia tri trong a < tan so gia tri trong b
                if (hashtable1.get(key).compareTo(hashtable2.get(key)) < 0) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void print(List<Integer> a)
    {
        for (int i = 0; i < a.size(); i++)
        {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    public static List<Integer> addAll(int[]a)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
        {
            result.add(a[i]);
        }
        return result;
    }

    public static void main(String []args)
    {
        int []a = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int []b = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
//        int []a = {1, 2, 3};
//        int []b = {1, 2, 2, 3, 3, 3};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1 = addAll(a);
        list2 = addAll(b);
        List<Integer> result = missingNumbers(list1, list2);
        print(result);
    }
}
