package Buoi4;

public class MergeTwoSortedList
{
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null)
        {
            return head2;
        }

        if(head2 == null)
        {
            return head1;
        }

        SinglyLinkedListNode head3 = new SinglyLinkedListNode(10);
        if(head1.data < head2.data)
        {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(head1.data);
            head1 = head1.next;
            head3 = newNode;
        }
        else
        {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(head2.data);
            head2 = head2.next;
            head3 = newNode;
        }

        SinglyLinkedListNode ptr3 = head3;


        while(head1 != null && head2!= null)
        {
            if(head1.data < head2.data)
            {
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(head1.data);
                head1 = head1.next;
                ptr3.next = newNode;
            }
            else
            {
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(head2.data);
                head2 = head2.next;
                ptr3.next = newNode;
            }

            ptr3 = ptr3.next;
        }

        if(head1 == null)
        {
            ptr3.next = head2;
        }
        else
        {
            ptr3.next = head1;
        }

        return head3;
    }

}
