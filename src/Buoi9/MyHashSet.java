package Buoi9;

import java.util.*;

public class MyHashSet {
    public static void main(String []args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        HashSet<String> hashSet = new HashSet<String>();

        for (int i = 0; i < n; i++)
        {
            String s = sc.nextLine();
            hashSet.add(s);
            System.out.println(hashSet.size());
        }
    }
}
