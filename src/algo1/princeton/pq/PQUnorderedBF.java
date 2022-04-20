package algo1.princeton.pq;

import algo.util.Util;

// this class can be used if client wants to N maximum number of elements of all time
public class PQUnorderedBF<T extends Comparable<T>> { // while deleting, delete the minimum among all

    private T[] pq; // array to keep elements
    private int capacity;
    private int N;  // number of elements in pq
    private final Util util = new Util<T>();

    public PQUnorderedBF(int capacity) { // ex. we need to keep 10 most viewed songs' list. 10 is capacity.
        pq = (T[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(T element) { // insert at the end
        if (N == capacity) { // if queue is already full, replace minimum in queue to the input element if its bigger
            T min = moveMinToEnd();
            if (element.compareTo(min) > 0) {
                System.out.println("removing " + min.toString() + " from the queue and inserting " + element.toString());
                pq[N-1] = element;
            }
        } else {
            pq[N++] = element;
        }
    }

    private T moveMinToEnd() { // move minimum element to the end and return the element
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (pq[i].compareTo(pq[min]) < 0) {
                min = i;
            }
        }
        util.swap(pq, min, N-1);
        return pq[N-1];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i< N ; i++) {
            if (i > 0) {
                s.append(", ");
            }
            s.append(pq[i].toString());
        }
        return s.toString();
    }


}
