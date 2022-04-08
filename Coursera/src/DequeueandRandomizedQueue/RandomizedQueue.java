package DequeueandRandomizedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private int size;

    private class Node
    {
        private Item value;
        private Node next;
    }

    public RandomizedQueue()
    {
        Node first = null;
        Node last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // add the item
    public void enqueue(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException();
        }
        Node newItem = new Node();
        newItem.value = item;
        newItem.next = first;
        first = newItem;
        size++;
    }

    // remove and return a random item
    public Item dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        Item oldItem;
        int index = (int) (Math.random() * (this.size() - 1));
        if (index == 0 || size() == 1)
        {
            oldItem = first.value;
            first = first.next;
            return oldItem;
        }
        Node ptr = first;
        int i = 0;
        while (ptr.next.next != null && i < index - 1)
        {
            ptr = ptr.next;
            i++;
        }
        oldItem = ptr.next.value;
        ptr.next = ptr.next.next;
        return oldItem;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        Item item;
        int index = (int) (Math.random() * (this.size() - 1));
        Node ptr = first;
        int i = 0;
        while (ptr.next.next != null && i < index - 1)
        {
            ptr = ptr.next;
            i++;
        }
        item = ptr.next.value;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        Iterator<Item> iterator = new Iterator<>()
        {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.value;
                current = current.next;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("Person2");
        randomizedQueue.enqueue("Person1");
        randomizedQueue.enqueue("Person3");
        randomizedQueue.enqueue("Person4");
        System.out.println(randomizedQueue.isEmpty());
        System.out.println("Size = " + randomizedQueue.size());
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        System.out.println(randomizedQueue.size());
        System.out.println(randomizedQueue.sample());
        for (String s : randomizedQueue) {
            System.out.print(s + " ");
        }
    }
}
