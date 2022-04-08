package Review;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    public static void main(String []args)
    {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int i = 1; i < 10; i++) {
            minPQ.add(i);
        }
        System.out.println(minPQ.peek());
    }
}
