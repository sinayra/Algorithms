import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }

    private Node first;
    private Node last;
    private int n;

    // construct an empty deque
    public Deque()
    {
        first = null;
        last = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return size() == 0;
    }

    // return the number of items on the deque
    public int size()
    {
        return n;
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
        first.item = item;
        first.next = oldFirst;
        first.previous = null;

        if (last == null)
        {
            last = first;
        }
        else
        {
            oldFirst.previous = first;
        }

        n++;
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
        last.item = item;
        last.next = null;

        if (isEmpty())
        {
            first = last;
            last.previous = null;
        }
        else
        {
            oldLast.next = last;
            last.previous = oldLast;
        }

        n++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        Item item = first.item;
        first = first.next;
        if (first == null)
        {
            last = null;
        }
        else
        {
            first.previous = null;
        }

        n--;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        Item item = last.item;
        last = last.previous;

        if (last == null)
        {
            first = null;
        }
        else
        {
            last.next = null;
        }

        n--;

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current;

        public ListIterator()
        {
            current = first;
        }

        @Override
        public boolean hasNext()
        {
            return current != null;
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

            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        Deque<Integer> test = new Deque<>();
        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 0)   test.addFirst(i);
            else    test.addLast(i);
        }
        System.out.println(test.isEmpty());

        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 0)   test.removeLast();
            else    test.removeFirst();
        }
        System.out.println(test.isEmpty());

        for (int i = 0; i < 1000; i++)
        {
            if (i %     2 == 0)   test.addLast(i);
            else    test.addFirst(i);
        }
        System.out.println(test.size());

        for (int i = 0; i < 1000; i++)
        {
            test.removeLast();
        }
        System.out.println(test.isEmpty());
    }
}
