package Buoi9;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String []args)
    {
        HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();
        int numberOfValue;
        Scanner sc = new Scanner(System.in);
        numberOfValue = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfValue; i++)
        {
            String name = sc.nextLine();
            int phoneNumber = sc.nextInt();
            sc.nextLine();
            phoneBook.put(name, phoneNumber);
        }

        while (sc.hasNext())
        {
            String findName = sc.nextLine();
            if(phoneBook.containsKey(findName))
            {
                System.out.println(findName + "=" + phoneBook.get(findName));
            }
            else
            {
                System.out.println("Not found");
            }
        }
    }
}
