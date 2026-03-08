package algo.heaps;

import java.util.Arrays;

/*
A heap is a complete binary tree, meaning:
- All levels filled
- Parent is always ≤ children for a min heap, children can be in any order
- smallest is at index 0 if it is a min heap
Last level filled left → right
Because of this structure, we can store it in an array without pointers.

Example: min heap
        2
       / \
      5   7
     / \
    9  10
Index:  0  1  2  3  4
Value: [2, 5, 7, 9,10]

And hence, for a node at index i:
left child  = 2*i + 1
right child = 2*i + 2
parent      = (i-1)/2

 */
public class HeapWithArray {

    static void main() {
        int [][] inputs = {
                {5, 3, 8, 1, 2, 7},
                {1, 2, 3, 4, 5, 6},
                {9, 8, 7, 6, 5, 4, 3},
                {4, 2, 2, 8, 3, 3, 1},
                {10},
                {9, 3},
                {-3, -1, -7, -2, 4, 0},
                {1, 5, 3, 8, 6, 7, 9},
                {1, 4, 2, 7, 8, 3},
                {10, 4, 15, 20, 0, 7, 9, 3}
        };
        int [] capacity = {1, 2, 3, 4, 5, 3, 4, 1, 2, 5};
        int [] outputsWithCapacity = {8, 5, 7, 3, 10, 3, -2, 9, 7, 7};
        int [] outputsWithoutCapacity = {1, 1, 3, 1, 10, 3, -7, 1, 1, 0};

        for (int i=0; i<inputs.length; i++) {

            ArrayBasedIntMinHeap heapWithoutCapacity = new ArrayBasedIntMinHeap(10);
            for (int j=0; j<inputs[i].length; j++) {
                heapWithoutCapacity.offer(inputs[i][j]);
            }
            int expected = outputsWithoutCapacity[i];
            int actual = heapWithoutCapacity.peek();
            String emoji = expected == actual ? "✅" : "❌";
            System.out.printf("%s Without capacity. expected: %d, actual: %d%n", emoji, expected, actual);

            ArrayBasedIntMinHeap heapWithCapacity = new ArrayBasedIntMinHeap(capacity[i]);
            for (int j=0; j<inputs[i].length; j++) {
                heapWithCapacity.insert(inputs[i][j]);
            }
            int expectedC = outputsWithCapacity[i];
            int actualC = heapWithCapacity.peek();
            String emojiC = expectedC == actualC ? "✅" : "❌";
            System.out.printf("%s With capacity. expected: %d, actual: %d%n", emojiC, expectedC, actualC);
            System.out.println(heapWithCapacity.asString());
            System.out.println();
        }

    }

    static class ArrayBasedIntMinHeap {

        private final int[] items;
        private int size;

        ArrayBasedIntMinHeap(int capacity) {
            this.items = new int[capacity];
            this.size = 0;
        }

        public int peek() {
            if (size== 0) {
                throw new IllegalStateException("Empty");
            }
            return items[0];
        }

        public void offer(int number) {
            if (size == items.length) {
                throw new IllegalStateException("Full");
            }
            items[size++] = number;
            shuffleUp();
        }

        public void insert(int number) {
            if (size < items.length) {
                offer(number);
            } else if (number > items[0]) {
                System.out.printf("Replacing %d with %d%n", items[0], number);
                items[0] = number;
                shuffleDown();
            } else {
                System.out.printf("Discarding %d%n", number);
            }
        }

        public int poll() {
            if (size== 0) {
                throw new IllegalStateException("Empty");
            }
            int item = items[0];
            items[0] = items[size-1];
            size--;
            shuffleDown();
            return item;
        }

        private void shuffleUp() {
            int current = size-1;
            while (getParentIndex(current) >= 0 && items[getParentIndex(current)] > items[current]) {
                swap(current, getParentIndex(current));
                current = getParentIndex(current);
            }
            System.out.printf("Item %d moved to %d index%n", items[current], current);
        }

        private void shuffleDown() {
            int current = 0;
            while (true) {
                int childLeft = 2*current + 1;
                int childRight = 2*current + 2;
                if (childLeft >= size) {
                    break;
                }
                // pick the minimum of children and replace if needed
                int minChildIndex = childLeft;
                if (childRight < size && items[childRight] < items[childLeft]) {
                    minChildIndex = childRight;
                }
                if (items[minChildIndex] < items[current]) {
                    swap(minChildIndex, current);
                    current = minChildIndex;
                } else {
                    break;
                }
            }
        }

        private void swap(int a, int b) {
            int temp = items[a];
            items[a] = items[b];
            items[b] = temp;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        public String asString() {
            return Arrays.toString(Arrays.copyOfRange(items, 0, size));
        }

    }

}
