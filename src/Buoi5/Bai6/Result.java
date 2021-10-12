package Buoi5.Bai6;

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

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static Stack<Integer> toStack(List<Integer> h)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = h.size() - 1; i >= 0; i--)
        {
            stack.push(h.get(i));
        }
        return stack;
    }

    public static int sum(List<Integer> h)
    {
        int sum = 0;
        for(int i = 0; i < h.size(); i++)
        {
            sum += h.get(i);
        }
        return sum;
    }

    public static int max(int a, int b, int c)
    {
        if(a > b && a > c)
        {
            return 1;
        }
        else if (b > c && b > a)
        {
            return 2;
        }
        return 3;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = toStack(h1);
        Stack<Integer> stack2 = toStack(h2);
        Stack<Integer> stack3 = toStack(h3);
        int sum1 = sum(h1);
        int sum2 = sum(h2);
        int sum3 = sum(h3);

        if(sum1 == sum2 && sum2 == sum3)
        {
            return sum1;
        }

        boolean equal = false;
        while(equal == false)
        {
            int sum_max = max(sum1, sum2, sum3);
            if (sum_max == 1)
            {
                sum1 -= stack1.peek();
                stack1.pop();
            }
            else if (sum_max == 2)
            {
                sum2 -= stack2.peek();
                stack2.pop();
            }
            else
            {
                sum3 -= stack3.peek();
                stack3.pop();
            }

            if(sum1 == sum2 && sum2 == sum3)
            {
                equal = true;
            }
        }
        return sum1;
    }

    public static void main (String []args)
    {

    }

}
