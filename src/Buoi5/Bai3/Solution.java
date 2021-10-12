package Buoi5.Bai3;

import java.io.*;
import java.util.*;

public class Solution {

    private Node first;
    private Node last;

    private class Node
    {
        private int value;
        private Node next;
    }

    public Solution()
    {
        Node first = null;
        Node last = null;
    }

    public void enqueue(int number) //add last
    {
        Node newNode = new Node();
        newNode.value = number;
        newNode.next = null;

        if (first == null)
        {
            first = newNode;
            return;
        }

        last.next = newNode;
        last = newNode;
    }

    public void dequeue() //remove first
    {
        if(first == null)
        {
            return;
        }
        first = first.next;
    }

    public void printFirst()
    {
        if(first != null)
        {
            System.out.println(first.value);
        }
        else
        {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Solution queue = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int choice = sc.nextInt();
            if (choice == 1)
            {
                int number = sc.nextInt();
                queue.enqueue(number);
            }
            else if (choice == 2)
            {
                queue.dequeue();
            }
            else if (choice == 3)
            {
                queue.printFirst();
            }
        }
    }
}
