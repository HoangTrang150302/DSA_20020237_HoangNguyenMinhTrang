package Buoi11;

import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class RunningMedian {
//    private static class Node implements Comparable<Node>
//    {
//        int value;
//        int index;
//        public int compareTo(Node other)
//        {
//            if (this.value == other.value)
//            {
//                return this.index - other.index;
//            }
//            return this.value - other.value;
//        }
//    }

    public static void main(String []args) {
        TreeSet<Double> tree = new TreeSet<>();
        Double median = Double.valueOf(0);
        while (!StdIn.isEmpty()) {
            double temp = Double.valueOf(StdIn.readInt());
            tree.add(temp);
            if (tree.size() == 1) {
                median = tree.last();
                System.out.print(median + " ");
                continue;
            }

            if (tree.size() % 2 == 0) {
                if (temp > median) {
                    median = (median + tree.higher(median)) / 2;
                }
                if (temp < median) {
                    median = (median + tree.lower(median)) / 2;
                }
            } else {
                if (temp > median) {
                    median = tree.higher(median);
                }
                if (temp < median) {
                    median = tree.lower(median);
                }
            }
            System.out.println(median);
        }
    }

//    public static Double addNode(List<Integer> a)
//    {
//        TreeSet<Node> treeSetLeft = new TreeSet<>();
//        TreeSet<Node> treeSetRight = new TreeSet<>();
//
////        if (treeSetLeft.isEmpty())
////        {
////            //treeSetLeft.add()
////        }
//
//        TreeSet<Node> treeSet = new TreeSet<>();
//        for (int i = 0; i < a.size(); i++)
//        {
//            Node node = new Node();
//            node.value = a.get(i);
//            node.index = i;
//            treeSet.add(node);
//        }
//
//        List<Node> arr = new ArrayList<>(treeSet);
//        // List<Node> arr = treeSet.stream().toList();
//        int n = arr.size();
//        if (n % 2 == 1)
//        {
//            return arr.get(n/2).value * 1.0;
//        }
//        else
//        {
//            return (arr.get(n/2).value + arr.get(n/2 - 1).value) * 1.0 / 2;
//        }
//    }
//
//    public static List<Double> runningMedian(List<Integer> a)
//    {
//        List<Double> result = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//
//        for (int i = 0; i < a.size(); i++)
//        {
//            b.add(a.get(i));
//            //result.add(findMedian(b));
//        }
//        return result;
//    }

//    public static void main(String []args)
//    {
//        List<Integer> a = new ArrayList<>();
//        List<Double> median = new ArrayList<>();
//        a.add(7);
//        a.add(3);
//        a.add(5);
//        a.add(2);
//        median = runningMedian(a);
//        System.out.println(median.toString());
//    }
}

