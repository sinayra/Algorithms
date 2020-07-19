import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

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

        arr[n++] = item;

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

        Item item = arr[--n];
        arr[n] = null;

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

            int index = StdRandom.uniform(n);

            Item aux = randomArr[size - 1];
            randomArr[size - 1] = randomArr[index];
            randomArr[index] = aux;

            Item item = randomArr[--size];
            randomArr[size] = null;

            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        RandomizedQueue<Integer> test = new RandomizedQueue<>();

        for (int i = 0; i < 100; i++) {
            test.enqueue(i);
        }
        System.out.println(test.size());

        Integer [] num = new Integer[100];
        for (int i = 0; i < 100; i++) {
            Integer n = test.dequeue();
            for (int j = 0; j < i; j++) {
                if (Objects.equals(num[j], n))
                {
                    System.out.println("wrong");
                }
            }
            num[i] = n;
        }
        System.out.println(test.size());

        for (int i = 0; i < 1000; i++) {
            test.enqueue(StdRandom.uniform(1000));
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(test.dequeue());
        }
        System.out.println(test.size());
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];

        if (n >= 0) System.arraycopy(arr, 0, copy, 0, n);

        arr = copy;
    }
}
