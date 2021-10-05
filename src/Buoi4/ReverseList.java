package Buoi4;

public class ReverseList
{
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if(llist == null || llist.next == null)
        {
            return llist;
        }

        SinglyLinkedListNode rest = reverse(llist.next);
        llist.next.next = llist;
        llist.next = null;
        return rest;
    }
}
