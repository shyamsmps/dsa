package algo.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an unsorted integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class Heap_Largest_Kth_Element {

    static void main() {
        int[][] inputs = {
                {3, 2, 3, 1, 2, 4, 5, 5, 6},
                {3, 2, 1, 5, 6, 4},
                {10, 20, 30},
                {3, 2, 3, 1, 2, 4, 5, 5, 6},
        };
        int [] ks = {4, 2, 1, 6};
        int[] results_kth_largest = {4, 5, 30, 3};
        int[][] result_k_largest = {
                {4, 5, 5, 6},
                {5, 6},
                {30},
                {3, 3, 4, 5, 5, 6}
        };

        for (int i=0; i<inputs.length; i++) {
            int[] nums = inputs[i];
            int k = ks[i];

            int expected = results_kth_largest[i];
            int actual = kthLargestElementUsingPriorityQueue(nums, k);
            String emoji = expected == actual ? "✅" : "❌";
            System.out.printf("%s input: %s, k: %s, expected: %s, actual: %s%n",
                    emoji,  Arrays.toString(nums), k, expected, actual);

            int[] expectedArray = result_k_largest[i];
            int[] actualArray = kLargestElementUsingPriorityQueue(nums, k);
            emoji = Arrays.equals(Arrays.stream(expectedArray).sorted().toArray(), Arrays.stream(actualArray).sorted().toArray()) ? "✅" : "❌";
            System.out.printf("%s input: %s, k: %s, expected: %s, actual: %s%n",
                    emoji,  Arrays.toString(nums),
                    k,
                    Arrays.toString(expectedArray),
                    Arrays.toString(actualArray));

            System.out.println();
        }
    }

    private static Integer kthLargestElementUsingPriorityQueue(int[] nums, int k) {
        // we need min heap to find the largest elements so that while removing, we can remove top element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i: nums) {
            minHeap.add(i);
            // ‼️remove after adding, because, new element may not be needed eventually
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    private static int[] kLargestElementUsingPriorityQueue(int[] nums, int k) {
        // we need min heap to find the largest elements so that while removing, we can remove top element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i: nums) {
            minHeap.add(i);
            // ‼️remove after adding, because, new element may not be needed eventually
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // ‼️weird java syntax, needs the type upfront, can't derive from the collection
        return Arrays.stream(minHeap.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }


}
