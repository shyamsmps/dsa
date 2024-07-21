package leet.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Solutions:

A really brute force way would be to search for all possible pairs of numbers but that would be too slow.
Again, it's best to try out brute force solutions for just for completeness.
It is from these brute force solutions that you can come up with optimizations.

So, if we fix one of the numbers, say x, we have to scan the entire array to find the next number y which is value - x where value is the input parameter.
Can we change our array somehow so that this search becomes faster?

The second train of thought is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?


 */
public class TwoSum {

    public static void main(String[] args) {
        int[][] nums = {{2,7,11,15}, {3,2,4}, {3,3}};
        int[] targets = {9, 6, 6};
        int[][] expected = {{0,1}, {1,2}, {0,1}};
        for (int i=0; i<nums.length; i++) {
            int[] result = withHashMap(nums[i], targets[i]);
            System.out.println("Input: nums = " + Arrays.toString(nums[i]) + ", target = " + Arrays.toString(result) + ", Expected: " + Arrays.toString(expected[i]));
        }
    }

    public static int[] withHashMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer index = map.get(target-nums[i]);
            if (index != null) {
                return new int[] { index, i };
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] bruteForce(int[] nums, int target) {
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
