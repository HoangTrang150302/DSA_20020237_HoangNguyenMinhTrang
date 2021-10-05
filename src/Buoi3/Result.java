import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    public static int max(int a, int b)
    {
        if(a > b)
        {
            return a;
        }
        return b;
    }

    public static void minimumBribes(List<Integer> q) {
        int count = 0;

        for(int i =  q.size() - 1; i >= 0; i--)
        {
            if(q.get(i) - i > 3)
            {
                System.out.println("Too chaotic");
                return;
            }

            for(int j = max(0, q.get(i) - 2); j < i; j++)
            {
                if(q.get(j) > q.get(i))
                {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}


