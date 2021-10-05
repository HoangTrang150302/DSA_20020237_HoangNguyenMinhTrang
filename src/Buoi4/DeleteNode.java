package Buoi4;

public class DeleteNode
{
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

        if(llist == null || llist.next == null)
        {
            return null;
        }

        if(position == 0)
        {
            llist = llist.next;
            return llist;
        }

        SinglyLinkedListNode node = llist;
        int count = 0;

        while (node.next != null && count < position - 1)
        {
            node = node.next;
            count++;
        }

        node.next = node.next.next;

        return llist;

    }
}
