package algo.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an unsorted integer array nums and an integer k, return the kth smallest element in the array.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */
public class Heap_Smallest_Kth_Element {

    static void main() {
        int[][] inputs = {
                {3, 2, 3, 1, 2, 4, 5, 5, 6},
                {3, 2, 1, 5, 6, 4},
                {40, 20, 10, 30},
                {3, 2, 3, 1, 2, 4, 5, 5, 6},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int [] ks = {4, 2, 1, 6, 3};
        int[] results_kth_smallest = {3, 2, 10, 4, 1};
        int[][] result_k_smallest = {
                {1, 2, 2, 3},
                {1, 2},
                {10},
                {1, 2, 2, 3, 3, 4},
                {1, 1, 1}
        };

        for (int i=0; i<inputs.length; i++) {
            int[] nums = inputs[i];
            int k = ks[i];

            int expected = results_kth_smallest[i];
            int actual = kthSmallestElementUsingPriorityQueue(nums, k);
            String emoji = expected == actual ? "✅" : "❌";
            System.out.printf("%s input: %s, k: %s, expected: %s, actual: %s%n",
                    emoji,  Arrays.toString(nums), k, expected, actual);

            int[] expectedArray = result_k_smallest[i];
            int[] actualArray = kSmallestElementUsingPriorityQueue(nums, k);
            emoji = Arrays.equals(Arrays.stream(expectedArray).sorted().toArray(), Arrays.stream(actualArray).sorted().toArray()) ? "✅" : "❌";
            System.out.printf("%s input: %s, k: %s, expected: %s, actual: %s%n",
                    emoji,  Arrays.toString(nums),
                    k,
                    Arrays.toString(expectedArray),
                    Arrays.toString(actualArray));

            System.out.println();
        }
    }

    private static Integer kthSmallestElementUsingPriorityQueue(int[] nums, int k) {
        // we need min heap to find the largest elements so that while removing, we can remove top element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i : nums) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    private static int[] kSmallestElementUsingPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i : nums) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return Arrays.stream(maxHeap.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }


}
