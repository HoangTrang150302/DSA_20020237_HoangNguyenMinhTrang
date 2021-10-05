package Buoi4;

class insertAtPosition {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        SinglyLinkedListNode node = llist;
        int count = 0;

        while(node.next != null && count < position - 1)
        {
            node = node.next;
            count++;
        }

        newNode.next = node.next;
        node.next = newNode;

        return llist;
    }
}
