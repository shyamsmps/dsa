package algo.data.structure.classes;

public class MinHeap {

    int[] heapArray;
    int hSize;
    int capacity;

    public MinHeap(int inputArray[]) {
        hSize = inputArray.length;
        capacity = inputArray.length;
        heapArray = inputArray;
        int i = (hSize - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < hSize && heapArray[l] < heapArray[i])
            smallest = l;
        if (r < hSize && heapArray[r] < heapArray[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }


    int left(int i) {
        return (2 * i + 1);
    }


    int right(int i) {
        return (2 * i + 2);
    }


    int extractMin() {
        if (hSize <= 0)
            return Integer.MAX_VALUE;
        if (hSize == 1) {
            hSize--;
            return heapArray[0];
        }


        int root = heapArray[0];
        heapArray[0] = heapArray[hSize - 1];
        hSize--;
        MinHeapify(0);

        return root;
    }


    void insertKey(int x) {
        if (hSize == capacity) {
            System.out.println("Could not insertKey");
            return;
        }


        hSize++;
        int i = hSize - 1;
        heapArray[i] = x;


        while (i != 0 && heapArray[parent(i)] > heapArray[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }


    boolean SizeIsOne() {
        return (hSize == 1);
    }


    void swap(int x, int y) {
        int temp = heapArray[x];
        heapArray[x] = heapArray[y];
        heapArray[y] = temp;
    }

}
