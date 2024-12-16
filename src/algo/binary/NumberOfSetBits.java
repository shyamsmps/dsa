package algo.binary;

/*

Lessons:

-----------------------------------------------------------------
Binary & operation returns 1 if both bits are 1, otherwise 0.

Doing n & (n-1), the rightmost bit is cleared.
This is because n-1 will have all bits same as n upto the rightmost set bit of n, and then all bits after that will be flipped.
Example: n = 10100, n-1 = 10011, n & (n-1) = 10000.
This can be used in following scenarios:
1. To check if a number is a power of 2. If n is a power of 2, n & (n-1) will be 0.
2. To count the number of set bits in a number.

If we do n & 1, we get the rightmost bit of n. If this returns 0, the rightmost bit is 0, otherwise 1.
Example: n = 10100, n & 1 = 0. n = 10101, n & 1 = 1.
This can be used in following scenarios:
1. To check if a number is odd or even. If n & 1 is 0, n is even, otherwise odd.
2. To count the number of set bits in a number.

-----------------------------------------------------------------
Binary right shift operator >> shifts bits to the right.

If we do n >> 1, we shift all bits to the right by 1. This is equivalent to dividing n by 2.
This essentially means clearing the rightmost bit.
Example: n = 10100, n >> 1 = 1010. n = 10101, n >> 1 = 1010.
-----------------------------------------------------------------

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 */
public class NumberOfSetBits {

    public static void main(String[] args) {
        int[] nums = {11, 128, 1294967291};
        int[] results = {3, 1, 19};

        for (int i = 0; i < nums.length; i++) {
            System.out.println("hammingWeightUsingAndRightShift: " + (hammingWeightUsingAndRightShift(nums[i]) == results[i]));
            System.out.println("hammingWeightUsingRightmostBitRemoval: " + (hammingWeightUsingRightmostBitRemoval(nums[i]) == results[i]));
        }
    }

    public static int hammingWeightUsingAndRightShift(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n = n >> 1;
        }
        return count;
    }

    public static int hammingWeightUsingRightmostBitRemoval(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
