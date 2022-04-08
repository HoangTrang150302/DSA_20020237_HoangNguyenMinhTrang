package Review;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueue {
    private int []array;
    int numberOfValue;

    public PriorityQueue(int initCapacity)
    {
        array = new int[initCapacity];
        numberOfValue = 0;
    }

    public PriorityQueue()
    {
        this(1);
    }

    public PriorityQueue(int []a)
    {
        numberOfValue = a.length;
        array = Arrays.copyOf(a, numberOfValue);
    }

    public boolean isEmpty()
    {
        return numberOfValue == 0;
    }

    public int size()
    {
        return numberOfValue;
    }

    public int max()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return array[1];
    }

    public void resize(int capacity)
    {
        if (capacity > numberOfValue)
        {
            int []temp = new int[capacity];
            for (int i = 0; i < numberOfValue; i++)
            {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public void swap(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void swim(int k)
    {
        // parent k/2
        while(k > 1 && array[k/2] < array[k])
        {
            swap(k, k/2);
            k = k/2;
        }
    }
}
