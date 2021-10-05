package Buoi4;

public class CompareList
{
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1 != null && head2 != null)
        {
            if(head1.data != head2.data)
            {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1 == null && head2 == null)
        {
            return true;
        }
        return false;
    }
}