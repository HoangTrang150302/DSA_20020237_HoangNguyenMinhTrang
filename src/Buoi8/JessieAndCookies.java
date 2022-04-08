package Buoi8;

import java.util.*;
import java.util.PriorityQueue;

public class JessieAndCookies {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(N);
        for (int i = 0; i < N; i++) {
            priorityQueue.add(7/*scanner.nextInt()*/);

        }

        int count = 0;
        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                count = -1;
                break;
            }
            Integer n = priorityQueue.remove();
            Integer m = priorityQueue.remove();
            priorityQueue.add(n + m * 2);
            count++;
            System.out.println(priorityQueue.toString());
        }
        //
        System.out.println(count);
    }
}
