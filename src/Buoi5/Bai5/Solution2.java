package Buoi5.Bai5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution2
{
    private Node first;
    private int numberOfValue;

    private class Node
    {
        String value;
        Node next;
    }

    Solution2()
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
        try
        {
            Solution2 stack = new Solution2();
            String s = "";
            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader sc = new BufferedReader(inputStream);
            int n = Integer.parseInt(sc.readLine());
            for(int i = 0; i < n; i++)
            {
                String input = sc.readLine();
                String[] inputArray = input.split(" ");
                if (inputArray[0] == "1")
                {
                    stack.addFirst(s);
                    String add = inputArray[1];
                    s += add;
                }
                else if (inputArray[0] == "2")
                {
                    int k = Integer.parseInt(inputArray[1]);
                    stack.addFirst(s);
                    if(k == s.length())
                    {
                        s = "";
                    }
                    else
                    {
                        s = s.substring(0, s.length() - k);
                    }
                }
                else if (inputArray[0] == "3")
                {
                    int k = Integer.parseInt(inputArray[1]);
                    System.out.println(s.charAt(k - 1));
                }
                else if (inputArray[0] == "4")
                {
                    s = stack.undo();
                }
            }
        }
        catch (NumberFormatException | IOException e)
        {
            e.printStackTrace();
        }

    }
}
