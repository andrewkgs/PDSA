# HW3: Deques

Write a generic data type for a deque . The goal of this assignment is to implement elementary data structures using arrays and/or linked lists, and to introduce you to generics and iterators.

## Deque.
A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure. Create a generic data type Deque that implements the following API:

```
public class Deque implements Iterable {
    public Deque() // construct an empty deque
    public boolean isEmpty() // is the deque empty?
    public int size() // return the number of items on the deque
    public void addFirst(Item item) // add the item to the front
    public void addLast(Item item) // add the item to the end
    public Item peekFirst() // return the item from the front, return null if the deque is empty.
    public Item peekLast() // return the item from the end, return null if the deque is empty.
    public Item removeFirst() // remove and return the item from the front
    public Item removeLast() // remove and return the item from the end
    public Iterator iterator() // return an iterator over items in order from front to end
    public static void main(String[] args) // unit testing
}
```

> Corner cases: <br/>
> Throw a java.lang.NullPointerException if the client attempts to add a null item. <br/>
> Throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque. <br/>
> Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator. <br/>
> Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return. <br/>

## Performance requirements.
Your deque implementation must support each deque operation in constant worst-case time and use space proportional to the number of items currently in the deque. Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.
