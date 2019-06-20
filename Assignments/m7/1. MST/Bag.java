import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * { size of type int}.
     */
    private int size;
    /**
     * { first of type node}.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { item of type Item }.
         */
        private Item item;
        /**
         * { next node address }.
         */
        private Node next;
    }
   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        size = 0;
    }
   /**
    * Determines if empty.
    * The time compleixty is constant.
    * @return     True if empty, False otherwise.
    */
    public boolean isEmpty() {
        return first == null;
    }
   /**
    * { size }.
    * The time compleixty is constant.
    * @return {returns size }
    */
    public int size() {
        return size;
    }
    /**
     * { adds item }
     * The time compleixty is constant.
     * @param      item  The item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    /**
     * { iterator }
     * The time complexity is O(N).
     * @return     { list }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * { current node }.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         * The time compleixty is constant.
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * { remove }.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * { next }.
         *
         * @return     { return current value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
