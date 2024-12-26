package collections;

import java.util.ArrayDeque;
import java.util.Arrays;

/*

Interfaces:

Queue:
    FIFO. Add elements at the end and remove elements from the beginning.
    Methods: add, offer, remove, poll, element, peek
    Implementations: ArrayDeque, LinkedList, PriorityQueue, ConcurrentLinkedQueue, LinkedBlockingQueue, PriorityBlockingQueue, ArrayBlockingQueue, DelayQueue, SynchronousQueue, TransferQueue
Deque:
    Double ended queue. Add and remove elements from both ends.
    Methods: addFirst, addLast, offerFirst, offerLast, removeFirst, removeLast, pollFirst, pollLast, getFirst, getLast, peekFirst, peekLast, offer, poll, peek
    Implementations: ArrayDeque, LinkedList,

 */
public class QueueClasses {

    public static void main(String[] args) {
        javaUtilArrayDeque();
    }

    private static void javaUtilArrayDeque() {
        // ArrayDeque. Array based implementation of the Deque interface. Lightweight and efficient.
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList("c", "d", "e"));

        // adding elements

        // from Deque interface. throws exception in case of failure example if the list is full
        deque.add("g"); // adds element to the end of the list
        deque.addFirst("b");
        deque.addLast("f");

        // adds elements. Returns true if successful, false if not.
        // Suitable for queues and deque where the size is limited, and we want to avoid exceptions. Graceful failure.
        deque.offer("h"); // adds element to the end of the list; from Queue interface
        deque.offerFirst("a"); // adds element to the beginning of the list; from Deque interface
        deque.offerLast("i"); // adds element to the end of the list; from Deque interface

        // retrieving elements

        String first = deque.getFirst(); // from Deque interface
        String last = deque.getLast(); // from Deque interface

        // from Queue and deque interfaces. Get elements. Returns null if the list is empty. Compare with getFirst() and getLast() where exception is thrown.
        String peek = deque.peek(); // retrieves the first element; from Queue and Deque interfaces
        String peekFirst = deque.peekFirst(); // from Deque interface
        String peekLast = deque.peekLast(); // from Deque interface

        System.out.println("Deque: " + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("GetFirst: " + first);
        System.out.println("GetLast: " + last);
        System.out.println("Peek: " + peek);
        System.out.println("PeekFirst: " + peekFirst);
        System.out.println("PeekLast: " + peekLast);
        System.out.println("Size: " + deque.size());

        // removing elements

        // removes elements and return the removed element. throws exception in case of failure example if the list is empty
        String removed = deque.remove(); // removes and returns the first element; from Queue and Deque interfaces
        String removedFirst = deque.removeFirst(); // from Deque interface
        String removedLast = deque.removeLast(); // from Deque interface

        // removes elements and return the removed element. Returns null if the list is empty. Compare with remove() and removeFirst() and removeLast() where exception is thrown.
        String poll = deque.poll(); // removes and returns the first element; from Queue and Deque interfaces
        String pollFirst = deque.pollFirst(); // from Deque interface
        String pollLast = deque.pollLast(); // from Deque interface

        System.out.println("Removed: " + removed);
        System.out.println("RemovedFirst: " + removedFirst);
        System.out.println("RemovedLast: " + removedLast);
        System.out.println("Poll: " + poll);
        System.out.println("PollFirst: " + pollFirst);
        System.out.println("PollLast: " + pollLast);
        System.out.println("Size: " + deque.size());

    }


}
