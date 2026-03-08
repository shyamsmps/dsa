package algo.heaps;

import java.util.*;

/*
Merge K sorted arrays.
 */
public class Heap_K_Way_Merge {

    static void main() {
        int[][][] inputs = {
                { {1, 4, 5}, {1, 3, 4}, {2, 6} }
        };
        int[][] results = {
                {1, 1, 2, 3, 4, 4, 5, 6}
        };

        for (int i=0; i<inputs.length; i++) {
            int[][] nums = inputs[i];
            int[] expected = results[i];
            int[] actual = kWayMerge(nums);
            String emoji = Arrays.equals(expected, actual) ? "✅" : "❌";
            System.out.printf("%s expected: %s, actual: %s%n",
                    emoji, Arrays.toString(expected), Arrays.toString(actual));
            System.out.println();
        }
    }

    /*
    Complexity: O(N log K)
    K is number of arrays, N is total number of elements. Each heap operation being log k as max k elements in heap.
    you can't just store the number; you have to store "metadata" (the coordinates) so you know which array to pull from next.
    This is to ensure that heap does not have more than k elements, else it will be very expensive
     */
    private static int[] kWayMerge(int[][] arrays) {
        int totalSize = Arrays.stream(arrays).mapToInt(a -> a.length).sum();
        int[] result = new int[totalSize];
        int index = 0;
        PriorityQueue<ElementToMerge> minHeap = new PriorityQueue<>(
                arrays.length,
                Comparator.comparingInt(a -> a.value)
        );
        for (int i=0; i<arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new ElementToMerge(i, 0, arrays[i][0]));
            }
        }
        while (!minHeap.isEmpty()) {
            ElementToMerge smallest = minHeap.poll();
            result[index++] = smallest.value;
            if (smallest.y < arrays[smallest.x].length - 1) {
                minHeap.offer(new ElementToMerge(smallest.x, smallest.y+1, arrays[smallest.x][smallest.y+1]));
            }
        }
        return result;
    }

    static class ElementToMerge {

        public ElementToMerge(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int x;
        public int y;
        public int value;
    }


}
