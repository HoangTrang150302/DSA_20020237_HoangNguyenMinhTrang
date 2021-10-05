package Buoi4;

public class GetNodeFromTail
{
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode ptr1 = llist;
        SinglyLinkedListNode ptr2 = llist;
        int count = 0;

        while(ptr1 != null)
        {
            ptr1 = ptr1.next;
            if(count > positionFromTail)
            {
                ptr2 = ptr2.next;
            }
            count++;
        }

        return ptr2.data;
    }
}
