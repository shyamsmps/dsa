package collections;

import java.util.Arrays;
import java.util.LinkedList;

/*

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
Doubly-linked list implementation of the List and Deque interfaces.

This implementation is not synchronized. The list can be "wrapped" using the Collections.synchronizedList method.
This is best done at creation time, to prevent accidental unsynchronized access to the list:
List list = Collections.synchronizedList(new LinkedList(...));

 */
public class LinkedListClasses {

    public static void main(String[] args) {

        javaUtilLinkedList();

    }

    private static void javaUtilLinkedList() {
        // LinkedList. Doubly-linked list implementation of the List and Deque interfaces.
        LinkedList<String> list = new LinkedList<>(Arrays.asList("c", "d", "e"));

        // adding elements

        // from Deque interface. throws exception in case of failure example if the list is full
        list.add("g"); // adds element to the end of the list
        list.addFirst("b");
        list.addLast("f");

        // adds elements. Returns true if successful, false if not.
        // Suitable for queues and deque where the size is limited, and we want to avoid exceptions. Graceful failure.
        list.offer("h"); // adds element to the end of the list; from Queue interface
        list.offerFirst("a"); // adds element to the beginning of the list; from Deque interface
        list.offerLast("i"); // adds element to the end of the list; from Deque interface

        // retrieving elements

        String first = list.getFirst(); // from Deque interface
        String last = list.getLast(); // from Deque interface

        // from Queue and deque interfaces. Get elements. Returns null if the list is empty. Compare with getFirst() and getLast() where exception is thrown.
        String peek = list.peek(); // retrieves the first element; from Queue and Deque interfaces
        String peekFirst = list.peekFirst(); // from Deque interface
        String peekLast = list.peekLast(); // from Deque interface

        System.out.println("List: " + list);
        System.out.println("GetFirst: " + first);
        System.out.println("GetLast: " + last);
        System.out.println("Peek: " + peek);
        System.out.println("PeekFirst: " + peekFirst);
        System.out.println("PeekLast: " + peekLast);

        // removing elements

        // removes elements and return the removed element. throws exception in case of failure example if the list is empty
        String removed = list.remove(); // removes and returns the first element; from Queue and Deque interfaces
        String removedFirst = list.removeFirst(); // from Deque interface
        String removedLast = list.removeLast(); // from Deque interface

        // removes elements and return the removed element. Returns null if the list is empty. Compare with remove() and removeFirst() and removeLast() where exception is thrown.
        String poll = list.poll(); // removes and returns the first element; from Queue and Deque interfaces
        String pollFirst = list.pollFirst(); // from Deque interface
        String pollLast = list.pollLast(); // from Deque interface

        System.out.println("Removed: " + removed);
        System.out.println("RemovedFirst: " + removedFirst);
        System.out.println("RemovedLast: " + removedLast);
        System.out.println("Poll: " + poll);
        System.out.println("PollFirst: " + pollFirst);
        System.out.println("PollLast: " + pollLast);

    }


}
