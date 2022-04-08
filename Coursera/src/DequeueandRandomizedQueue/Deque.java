package DequeueandRandomizedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node
    {
        private Item value;
        private Node prev;
        private Node next;
    }

    public Deque()
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

    // add the item to the front
    public void addFirst(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
        first.prev = null;
        if (isEmpty())
        {
            last = first;
        }
        else
        {
            oldFirst.prev = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node();
        last.value = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        Item oldFirst = first.value;
        size--;
        if (isEmpty())
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
            first.prev = null;
        }
        return oldFirst;
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        Item oldLast = last.value;
        size--;
        if (isEmpty())
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.prev;
            last.next = null;
        }
        return oldLast;
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
        Deque<String> deque = new Deque<>();
        //deque.addFirst(null);
        deque.addFirst("Person2");
        deque.addFirst("Person1");
        deque.addLast("Person3");
        deque.addLast("Person4");
        System.out.println(deque.isEmpty());
        System.out.println("Size = " + deque.size());
        deque.removeFirst();
        deque.removeLast();
        for (String s : deque) {
            System.out.print(s + " ");
        }
    }

}