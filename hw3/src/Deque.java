import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable {

    private class Node{
        Item item;
        Node next;
    }

    private Node first, last;

    private int s;

    // construct an empty deque
    public Deque(){}

    // is the deque empty
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        s = 0;
        if (isEmpty()) {
            return 0;
        }
        else {
            Node ref = first;
            while (ref.next != null) {
                ref = ref.next;
                s++;
            }
            return s+1; // Since the first node is not counted.
        }
    }
    // add the item to the front
    public void addFirst(Item item){
        if (item == null){ throw new NullPointerException(); }
        if (isEmpty()){
            first = new Node();
            first.item = item;
            last = first;
        }
        else{
            Node old_first = first;
            first = new Node();
            first.item = item;
            first.next = old_first;
        }
    }

    // add the item to the end
    public void addLast(Item item){
        if (item == null){ throw new NullPointerException(); }
        if (isEmpty()){
            last = new Node();
            last.item = item;
            first = last;
        }
        else {
            Node old_last = last;
            last = new Node();
            last.item = item;
            last.next = null;
            old_last.next = last;
        }
    }

    // return the item from the front, return null if the deque is empty.
    public Item peekFirst(){
        if (isEmpty()){ return null; }
        else{ return first.item; }
    }

    // return the item from the end, return null if the deque is empty.
    public Item peekLast(){
        if (isEmpty()){ return null; }
        else{ return last.item; }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (isEmpty()){ throw new NoSuchElementException(); }
        Item item = first.item;
        s = size();
        if (s == 1){
            first = null;
            last = null;
        }
        else{
            first = first.next;
        }
        return item;
    }

    // remove and return the item from the end
    public Item removeLast(){
        if (isEmpty()){ throw new NoSuchElementException(); }
        Item item = last.item;
        s = size();
        if (s == 1){
            first = null;
            last = null;
        }
        else {
            Node temp;
            temp = first;
            if (s == 2) {
                last = temp;
                last.next = null;
            }
            else {
                for (int i = 1; i < s - 1; i++) {
                    temp = temp.next;
                }
                last = temp;
                last.next = null;

            }
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){ return new ListIterator(); }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if (!hasNext()){ throw new NoSuchElementException(); }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // you can test your code here; we won't execute your main function.
    public static void main(String[] args){
    }
}