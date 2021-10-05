package Buoi4;

public class printReverse
{
    public static void reversePrint(SinglyLinkedListNode llist)
    {
        if(llist == null)
        {
            return;
        }
        reversePrint(llist.next);
        System.out.println(llist.data);
    }
}
