package algo.binary;

/*
Lessons:

XOR (^) operation returns 1 if both bits are different, otherwise 0.
- If this is performed on the same number, the result will be 0.
- If this is performed on a number and 0, the result will be the number itself.
- If this is performed on a number and 1, the result will be the number flipped.
- If this is performed on two different numbers, the result will be the bits that are different.

AND (&) operation returns 1 if both bits are 1, otherwise 0.
- If this is performed on the same number, the result will be the number itself.
- If this is performed on a number and 0, the result will be 0.
- If this is performed on a number and 1, the result will be the number itself.
- If this is performed on two different numbers, the result will be the bits that are same.

OR (|) operation returns 1 if any of the bits are 1, otherwise 0.
- If this is performed on the same number, the result will be the number itself.
- If this is performed on a number and 0, the result will be the number itself.
- If this is performed on a number and 1, the result will be 1.
- If this is performed on two different numbers, the result will be the bits that are 1 in either number.

NOT (~) operation flips the bits. 1 becomes 0 and 0 becomes 1.
- If this is performed on the same number, the result will be the number flipped.
- If this is performed on 0, the result will be all 1s.
- If this is performed on 1, the result will be all 0s.
- If this is performed on two different numbers, the result will be the bits flipped in both numbers.

 */
public class HammingDistance {

    public static void main(String[] args) {
        int[][] nums = {
            {1, 4},
            {3, 1}
        };
        int[] results = {2, 1};
        for (int i = 0; i < nums.length; i++) {
            System.out.println("hammingDistanceUsingXOR: " + (hammingDistanceUsingXOR(nums[i][0], nums[i][1]) == results[i]));
        }
    }

    public static int hammingDistanceUsingXOR(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count = count + (xor & 1);
            xor = xor >> 1;
        }
        return count;
    }
}
