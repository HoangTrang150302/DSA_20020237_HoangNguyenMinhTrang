package Buoi7;

import java.util.Objects;

public class ProrityQueue {
    private Node first;
    private int numberOfValue;
    private String maxValue;

    private class Node
    {
        String value;
        Node next;
    }

    ProrityQueue()
    {
        first = null;
        numberOfValue = 0;
        maxValue = "";
    }

    public void insert(String s)
    {
        Node newNode = new Node();
        newNode.value = s;
        newNode.next = first;
        first = newNode;
        numberOfValue++;
        if(s.compareTo(maxValue) > 0)
        {
            maxValue = s;
        }
        numberOfValue++;
    }

    public void deleteMax()
    {
        if(first == null || first.next == null)
        {
            numberOfValue = 0;
            first = null;
            return;
        }

        for(Node ptr = first; ptr.next!= null; ptr = ptr.next)
        {
            Node prev = first;
            if(Objects.equals(ptr.value, maxValue))
            {
                ptr.next = ptr.next.next;
                break;
            }
        }
        numberOfValue--;
    }

    public void print()
    {
        for (Node ptr = first; ptr != null; ptr = ptr.next)
        {
            System.out.print(ptr.value + " ");
        }
        System.out.println();
    }

    public static void main(String []args)
    {
        ProrityQueue prorityQueue = new ProrityQueue();
        prorityQueue.insert("A");
        prorityQueue.insert("B");
        prorityQueue.insert("C");
        prorityQueue.print();
        prorityQueue.deleteMax();
        prorityQueue.print();
    }
}
