package algo.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Find Median from Data Stream.
You are receiving a continuous stream of integers.
At any given moment, you need to be able to report the median of all the integers you have seen so far.
The median is the middle value (mid-element or avg of two mid-elements) in an ordered integer list.
 */
public class Heap_Median_From_Data_Stream {

    static void main() {
        int[][] inputs = {
                {5, 15, 1, 3},
                {10, 20, 30, 40},
                {100, 50, 25},
                {2, 100, 4, 200, 3},
                {12, 4, 5, 3, 8, 7, 10, 2, 21, 9}
        };
        double[][] expectedResults = {
                {5.0, 10.0, 5.0, 4.0},
                {10.0, 15.0, 20.0, 25.},
                {100.0, 75.0, 50.0},
                {2.0, 51.0, 4.0, 52.0, 4.0},
                {12.0, 8.0, 5.0, 4.5, 5.0, 6.0, 7.0, 6.0, 7.0, 7.5}
        };

        for (int i=0; i<inputs.length; i++) {
            int[] nums = inputs[i];
            System.out.println(Arrays.toString(nums));
            double[] expected = expectedResults[i];
            MedianUsingHeaps medianUsingHeaps = new MedianUsingHeaps();
            for (int j=0; j<nums.length; j++) {
                medianUsingHeaps.add(nums[j]);
                double actualMedian = medianUsingHeaps.median();
                double expectedMedian = expected[j];
                String emoji =expectedMedian == actualMedian ? "✅" : "❌";
                System.out.printf("%s expected median at %s: %s, actual: %s", emoji,  j, expectedMedian, actualMedian);
                System.out.println();
            }
            System.out.println();
        }
    }

    static class MedianUsingHeaps {

        // idea is, elements in left have to always be smaller than elements in right
        // and, in left, first element is the largest, in right, first element is the smallest
        // and hence, we can just do left and right and get median

        private final PriorityQueue<Integer> left;
        private final PriorityQueue<Integer> right;
        public MedianUsingHeaps() {
            left = new PriorityQueue<>(Collections.reverseOrder()); // max heap
            right = new PriorityQueue<>(); // min heap
        }

        public void add(int i) {
            // add it to left first
            left.offer(i);
            // reshuffle to make sure largest in left so far is moved to the right
            right.offer(left.poll());
            // left size should be greater or equals for easy calculation of average, shuffle if needed
            if (right.size() > left.size()) {
                left.offer(right.poll());
            }
        }

        public double median() {
            if (left.isEmpty()) {
                throw new IllegalStateException("No elements yet");
            } else if (left.size() > right.size()) {
                return left.peek();
            } else {
                return (left.peek() + right.peek())/2.0;
            }
        }

    }

}
