package Buoi11;

import edu.princeton.cs.algs4.In;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Pairs {

//    public static int pairs(int k, List<Integer> arr) {
//        Collections.sort(arr);
//        int count = 0;
//
//        for(int i = 0; i < arr.size(); i++)
//        {
//            int n = arr.get(i) + k;
//            for(int j = i + 1; j < arr.size() && arr.get(j) <= n; j++)
//            {
//                if(arr.get(j) == n)
//                {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for(int i = 0; i < arr.size(); i++)
        {
            int n = arr.get(i) + k;
            for(int j = i + 1; j < arr.size() && arr.get(j) <= n; j++)
            {
                if(arr.get(j) == n)
                {
                    hashtable.put(arr.get(i), arr.get(j));
                }
            }
        }
        return hashtable.size();
    }

//    public static int pairs(int k, List<Integer> arr) {
//        int count = 0;
//        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
//        for (int i = 0; i < arr.size(); i++)
//        {
//            hashtable.put(i, arr.get(i));
//        }
//
//        for (int i = 0; i < arr.size(); i++)
//        {
//           if (hashtable.contains(arr.get(i) + 1))
//           {
//               count++;
//           }
//        }
//        return count;
//    }
}
//Math.abs(arr.get(j) - arr.get(i)) == k