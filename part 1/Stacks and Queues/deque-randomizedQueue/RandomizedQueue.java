import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue

    private Item[] arr;
    private int n;

    public RandomizedQueue()
    {
        arr = (Item[]) new Object[1];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return n;
    }

    // add the item
    public void enqueue(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException();
        }

        if (n == arr.length)
        {
            resize(2 * arr.length);
        }

        arr[n] = item;
        n++;

    }

    // remove and return a random item
    public Item dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(n);

        Item aux = arr[n - 1];
        arr[n - 1] = arr[index];
        arr[index] = aux;

        Item item = arr[n - 1];
        arr[n - 1] = null;
        n--;

        if (n > 0 && n == arr.length/4)
        {
            resize(arr.length/2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(n);

        return arr[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item>
    {
        private final Item[] randomArr;
        private int size;

        public RandomArrayIterator()
        {
            randomArr = (Item[]) new Object[n];
            if (n >= 0) System.arraycopy(arr, 0, randomArr, 0, n);

            size = n;
        }
        @Override
        public boolean hasNext()
        {
            return size > 0;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            int index = StdRandom.uniform(size);

            Item aux = randomArr[size - 1];
            randomArr[size - 1] = randomArr[index];
            randomArr[index] = aux;

            Item item = randomArr[size - 1];
            randomArr[size - 1] = null;
            size--;

            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        for (int i = 0; i <= 5; i++) rq.enqueue(i);
        for (Integer i : rq) System.out.print(i + " ");
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];

        if (n >= 0) System.arraycopy(arr, 0, copy, 0, n);

        arr = copy;
    }
}
