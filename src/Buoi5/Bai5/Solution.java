package Buoi5.Bai5;

import java.util.Scanner;
import java.util.Stack;

public class Solution
{
    private Node first;
    private int numberOfValue;

    private class Node
    {
        String value;
        Node next;
    }

    Solution()
    {
        first = null;
        numberOfValue = 0;
    }

    public void addFirst(String s)
    {
        Node newNode = new Node();
        newNode.value = s;
        newNode.next = first;
        first = newNode;
        numberOfValue++;
    }

    public void removeFirst()
    {
        if(first == null)
        {
            return;
        }
        first = first.next;
    }

    public String undo()
    {
        String result = first.value;
        removeFirst();
        return result;
    }

    public static void main(String []args)
    {
        Solution stack = new Solution();
        String s = "";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int choice = sc.nextInt();
            if (choice == 1)
            {
                stack.addFirst(s);
                String add = sc.next();
                s += add;
            }
            else if (choice == 2)
            {
                int k = sc.nextInt();
                stack.addFirst(s);
                s = s.substring(0, s.length() - k);
            }
            else if (choice == 3)
            {
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1));
            }
            else if (choice == 4)
            {
                s = stack.undo();
            }
        }
    }
}
