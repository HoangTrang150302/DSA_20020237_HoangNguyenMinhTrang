package Buoi8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {
    private static PriorityQueue<Integer> maxPQ = new java.util.PriorityQueue<Integer>(Collections.reverseOrder());//smaller value
    private static PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();

    public static void addNumber(int n)
    {
        if (maxPQ.isEmpty())
        {
            maxPQ.add(n);
        }
        else
        {
            if (maxPQ.size() == minPQ.size())
            {
                if (n < maxPQ.peek())
                {
                    maxPQ.add(n);
                }
                else
                {
                    minPQ.add(n);
                    maxPQ.add(minPQ.remove());
                }
            }
            else if (maxPQ.size() > minPQ.size())
            {
                if (n > maxPQ.peek())
                {
                    minPQ.add(n);
                }
                else
                {
                    maxPQ.add(n);
                    minPQ.add(maxPQ.remove());
                }
            }
        }
    }

    public static double getMedian()
    {
        if(maxPQ.isEmpty())
        {
            return 0;
        }
        else if (maxPQ.size() == minPQ.size())
        {
            return (maxPQ.peek() + minPQ.peek()) / 2.0;
        }
        else
        {
            return maxPQ.peek();
        }
    }

    public static List<Double> runningMedian(List<Integer> a)
    {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++)
        {
            addNumber(a.get(i).intValue());
            result.add(getMedian());
        }
        return result;
    }

    public static void main(String []args)
    {
        List<Integer> a = new ArrayList<>();
        List<Double> median = new ArrayList<>();
        a.add(7);
        a.add(3);
        a.add(5);
        a.add(2);
        median = runningMedian(a);
        System.out.println(median.toString());
    }
}
