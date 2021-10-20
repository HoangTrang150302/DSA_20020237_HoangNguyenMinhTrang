package Buoi6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {
    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void print(List<Integer> arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        Integer value = Integer.valueOf(arr.get(n - 1));
        for (int i = n - 1; i >= 0; i--)
        {
            if(i != 0 && value < arr.get(i - 1))
            {
                arr.set(i, arr.get(i - 1));
                print(arr);
            }
            else
            {
                arr.set(i, value);
                print(arr);
                break;
            }
        }
    }

    public static void insertionSort2(int n, List<Integer> arr) {
        for(int j = 1; j < n; j++)
        {
            if(arr.get(j) < arr.get(j - 1))
            {
                Integer value = Integer.valueOf(arr.get(j));
                for (int i = j; i >= 0; i--)
                {
                    if(i != 0 && value < arr.get(i - 1))
                    {
                        Collections.swap(arr, i , i - 1);
                    }
                    else break;
                }
            }
            print(arr);
        }
    }
}



