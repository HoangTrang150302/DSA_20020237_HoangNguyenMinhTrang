import edu.princeton.cs.algs4.*;

public class ELEMENT
{
    public int id;
    public boolean connected;

    public static boolean check(ELEMENT []elements)
    {
        for(int i = 0; i < elements.length - 1; i++)
        {
            if(elements[i].id != elements[i + 1].id)
            {
                return false;
            }
        }
        return true;
    }

    public static void print(ELEMENT []elements)
    {
        for(int i = 0; i < elements.length; i++)
        {
            StdOut.print(elements[i].id + " ");
        }
        StdOut.println();
    }


    public static void main(String args[])
    {
        int count = 0; // bien dem so phan tu connect
        int n = StdIn.readInt(); //input n
        StdOut.println(n);
        ELEMENT[] elements = new ELEMENT[n]; // tao mang cac element
        for (int i = 0; i < n; i++)
        {
            elements[i] = new ELEMENT(); // khoi tao cho tung phan tu
            elements[i].id = i;
            elements[i].connected = false;
        }

        while (!StdIn.isEmpty())
        {
            int p, q;
            do // validate input
            {
                p = StdIn.readInt(); //input p and q
                q = StdIn.readInt();
            }
            while (p > n || q > n || p < 0 || q < 0);

            StdOut.println(elements[p].id + " " + elements[q].id);

            if (elements[p].connected || elements[q].connected)
            {
                int a = elements[p].id;
                for(int i = 0; i < elements.length; i++)
                {
                    if(elements[i].id == a)
                    {
                        StdOut.println(elements[i].id + " i = " + i);
                        elements[i].id = elements[q].id;
                        elements[i].connected = true;
                    }
                }
            }
            else
            {
                elements[p].id = elements[q].id;
                elements[p].connected = true;
                elements[q].connected = true;
            }
            print(elements);

            count++;
            StdOut.println(elements[p].id + " " + elements[q].id);
            if(check(elements))
            {
                StdOut.println(count);
                return;
            }
        }
        StdOut.println("FALSE");
    }
}
