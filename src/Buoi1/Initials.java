public class Initials
{
    public static void main(String [] args)
    {
        int n = 9;
        int m = 14;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(i == 1 || i == 2 || j == m/2 || j == m/2 + 1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
