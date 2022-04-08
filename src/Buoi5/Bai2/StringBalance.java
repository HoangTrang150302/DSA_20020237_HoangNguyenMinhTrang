package Buoi5.Bai2;

import java.util.Stack;

public class StringBalance
{
    public static String isBalanced(String s) {
        if(s.length() % 2 == 1)
        {
            return "NO";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(')
            {
                stack.push(c);
            }
            else if(stack.isEmpty())
            {
                return "NO";
            }
            else if (c == ')')
            {
                if (stack.peek() != '(')
                {
                    return "NO";
                }
                stack.pop();
            }
            else if (c == ']')
            {
                if(stack.peek() != '[')
                {
                    return "NO";
                }
                stack.pop();
            }
            else if (c == '}')
            {
                if(stack.peek() != '{')
                {
                    return "NO";
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String []args)
    {
        String s = "{()}";
    }
}


