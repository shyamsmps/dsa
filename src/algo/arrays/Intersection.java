package algo.arrays;

import java.util.*;

/*

Lessons:

Math.min(int a, int b) returns the smaller of two int values.

Arrays.copyOfRange(int[] original, int from, int to) returns a new array that contains the specified range from index from to index to - 1.

Arrays.sort(int[] a) sorts the specified array of integers into ascending numerical order.

Map.merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
performs the given merging function on the given key and its current mapped value (or null if there is no current mapping).
If no mapping exists for the key, the given value is added to the map.
It is kind og putIfAbsent and then apply the function.

Integer.sum(int a, int b) returns the sum of two int values.

Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Intersection {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1,2,2,1},
                {1,2,3,4,5},
                {1,1,1,1,1,1,1,1,1,1,1,1,10,10035523}
        };
        int[][] arr2 = {
                {1,1},
                {1,2,3,4,5},
                {100,3,4,5,6,7,1,1,3,1,1,-1}
        };
        for (int i = 0; i < arr1.length; i++) {
            int[] output = intersectOnSortedArrays(arr1[i], arr2[i]);
            System.out.println("intersection of " + Arrays.toString(arr1[i]) + " and " + Arrays.toString(arr2[i]) + " is " + Arrays.toString(output));
        }
    }

    public static int[] intersectOnSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, count=0, l1=nums1.length, l2=nums2.length;
        int[] a = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i<l1 && j<l2) {
            int num1 = nums1[i], num2 = nums2[j];
            if (num1 == num2) {
                a[count++] = num1;
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(a, 0, count);
    }

    public static int[] bruteforceIntersectUsingMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.merge(i, 1, Integer::sum);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums2) {
            map2.merge(i, 1, Integer::sum);
        }
        return intersection(map1, map2);
    }

    public static int[] intersection(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        if (map2.size() < map1.size()) {
            return intersection(map2, map1);
        }
        List<Integer> common = new ArrayList<>();
        map1.forEach((key, val) -> {
            Integer val2 = map2.get(key);
            if (val2 != null) {
                for (int i = 0; i < Math.min(val, val2); i++) {
                    common.add(key);
                }
            }
        });
        return common.stream().mapToInt(Integer::intValue).toArray();
    }

}
