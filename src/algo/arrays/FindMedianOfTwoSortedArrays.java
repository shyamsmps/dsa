package algo.arrays;

/**
 * The median is the central value of a Set Sorted in ascending order.
 * If there are an even number of items in the set, then the median is equal to the mean (average) of the 2 middle-most values.
 * Implement a function that takes two sorted arrays, which may have different lengths and finds the median of the two arrays (after merging).
 */
public class FindMedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[][] input = {
                {5, 8, 10, 11, 20, 26}, {900},
                {5, 8, 10, 11, 20}, {900},
                {5, 8, 10, 11, 20}, {1, 2, 6, 9, 13, 31},
                {3, 5, 8, 10, 11, 20}, {1, 2, 6, 9, 13, 31},
                {}, {1},
                {2}, {1},
                {25, 28, 102}, {2, 4, 6, 8, 19},
                {2, 4, 6, 8, 19, 23}, {25, 28, 102},
                {1,3}, {2}
        };
        double [] output = {11, 10.5, 9, 8.5, 1, 1.5, 13.5, 19, 2};
        for (int i=0; i< input.length; i=i+2) {
            double median1 = getMedianBruteForce(input[i], input[i+1]);
            double median2 = getMedianDivideAndConquer1(input[i], input[i+1]);
            System.out.println("BF | " + Double.valueOf(median1).equals(output[i/2]) + ". Expected: " + output[i/2] + ", Actual: " + median1);
            System.out.println("DC | " + Double.valueOf(median2).equals(output[i/2]) + ". Expected: " + output[i/2] + ", Actual: " + median2);
        }
    }

    /**
     * Brute force. Kind of combining both arrays and finding the middle elements.
     * Complexity: O((m+n)/2) ~ O(m+n). No extra space needed.
     */
    public static double getMedianBruteForce(int array1[], int array2[]) {
        int l1 = array1.length;
        int l2 = array2.length;
        int l = l1+l2;
        int mid = (l/2);
        int i=0;
        int j=0;
        int k=0;
        boolean isEven = l%2==0;
        int a=0;
        while(k<=mid) {
            boolean isMedianNums = isEven ? (k==mid-1 || k==mid) : (k==mid);
            if (j==l2 || i<l1 && array1[i] < array2[j]) {
                if (isMedianNums) {
                    a+=array1[i];
                }
                i++;
            } else {
                if (isMedianNums) {
                    a+=array2[j];
                }
                j++;
            }
            k++;
        }
        return (double) a/(isEven ? 2 : 1);
    }

    /**
     * https://www.youtube.com/watch?v=LPFhl65R7ww
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     * find a partition in both arrays where one part has all elements less that the other part.
     * once found middle, pick the numbers around that partition to calculate median.
     * complexity: O(log(min(nums1.length, nums2.length)))
     */
    public static double getMedianDivideAndConquer(int[] nums1, int[] nums2) {
        if (nums2.length<nums1.length) {
            return getMedianDivideAndConquer(nums2, nums1);
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int low = 0;
        int high = l1;
        while(low<=high) {

            // in case of odd combined length, we need one extra element on the left side
            int elementsLeft1 = (low+high)/2; // number of elements in left partition of nums1
            int elementsLeft2 = (l1+l2+1)/2-elementsLeft1; // number of elements in left partition of nums2

            // corner case. if no elements left any arrays, set numbers around partition to MIN or MAX depending of left(MIN) or right(MAX)
            int maxLeft1 = elementsLeft1 == 0 ? Integer.MIN_VALUE : nums1[elementsLeft1-1];
            int maxLeft2 = elementsLeft2 == 0 ? Integer.MIN_VALUE : nums2[elementsLeft2-1];
            int minRight1 = elementsLeft1 == l1 ? Integer.MAX_VALUE : nums1[elementsLeft1];
            int minRight2 = elementsLeft2 == l2 ? Integer.MAX_VALUE : nums2[elementsLeft2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) { // found
                if ((l1+l2)%2 == 0) { // even, need two elements. One from left and another from right
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2;
                } else { // odd, need one element. from left partition.
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) { // need to move further left in nums1's partition
                high = elementsLeft1-1;
            } else { // need to move further right in nums1's partition
                low = elementsLeft1+1;
            }
        }
        // we will reach here if arrays are not sorted. throw exception.
        throw new IllegalArgumentException();
    }

    public static double getMedianDivideAndConquer1(int[] array1, int[] array2) {

        if (array2.length<array1.length) {
            return getMedianDivideAndConquer(array2, array1);
        }

        int size1 = array1.length;
        int size2 = array2.length;
        int end = size1;
        int start = 0, i = 0, j = 0, median = 0;

        while (start <= end) {
            i = (start + end) / 2;
            j = ((size1 + size2 + 1) / 2) - i;

            if (i < size1 && j > 0 && array2[j - 1] > array1[i])
                start = i + 1;

            else if (i > 0 && j < size2 && array2[j] < array1[i - 1])
                end = i - 1;

            else { // found. derive max element in left partition, i.e. the first median
                if (i == 0) // no elements of array1 in left partition
                    median = array2[j - 1];

                else if (j == 0) // no elements of array2 in left partition
                    median = array1[i - 1];
                else // elements from both arrays are present
                    median = Math.max(array1[i - 1],
                            array2[j - 1]);
                break;
            }
        }

        if ((size1 + size2) % 2 == 1) {// total length odd
            return (double) median;
        } else { // total length even. derive second median.
            if (i == size1) // if all elements of array1 are used in left partition, no array1 elements left in right
                return (median + array2[j]) / 2.0;
            else if (j == size2) // if all elements of array2 are used in left partition, no array2 elements left in right
                return (median + array1[i]) / 2.0;
            else // elements from both arrays are there in right partition. find minimum
                return (median + Math.min(array1[i], array2[j])) / 2.0;
        }

    }

}
