package Buoi8;

import java.util.*;
import java.util.PriorityQueue;

public class Median {
    public static Double findMedian(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ)
    {
        if (maxPQ.size() > minPQ.size())
        {
            return maxPQ.peek().doubleValue();
        }
        else if (maxPQ.size() < minPQ.size())
        {
            return minPQ.peek().doubleValue();
        }
        return (maxPQ.peek().doubleValue() + minPQ.peek().doubleValue())/2;
    }

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();

        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(N/2 + 1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(N/2 + 1, Collections.reverseOrder());

        List<Integer> a = new ArrayList<>();

        List<Double> result = new ArrayList<>();
        Double median;

        for(int i = 0; i < N; i++)
        {
            Integer value = scanner.nextInt();
            a.add(value);

            if (i == 0)
            {
                minPQ.add(a.get(i));
                maxPQ.add(a.get(i));
            }
            else
            {
                if (a.get(i) > minPQ.peek())
                {
                    if (i == 1)
                    {
                        maxPQ.remove();
                    }
                    else if (maxPQ.size() > minPQ.size())
                    {
                        minPQ.add(maxPQ.peek());
                        maxPQ.remove();
                    }
                    maxPQ.add(a.get(i));
                }
                else
                {
                    if (i == 1)
                    {
                        minPQ.remove();
                    }
                    else if (minPQ.size() > maxPQ.size())
                    {
                        maxPQ.add(minPQ.peek());
                        minPQ.remove();
                    }
                    minPQ.add(a.get(i));
                }
            }

            result.add(findMedian(maxPQ, minPQ));
            //System.out.println(minPQ.toString() + " " + maxPQ.toString());

        }System.out.println(result.toString() + "\n");
    }
}
