package algo.binary;

public class ReverseBits {

    public static void main(String[] args) {
        int[] nums = {43261596, -3};
        int[] results = {964176192, -1073741825};

        for (int i = 0; i < nums.length; i++) {
            System.out.println("reverseBits: " + (reverseBits(nums[i]) == results[i]));
        }
    }

    public static int reverseBits(int n) {
        int reversed = 0; // Store the reversed bits
        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1; // Extract the least significant bit
            reversed = (reversed << 1) | lastBit; // Shift reversed left and add the bit
            n >>= 1; // Shift input to the right for the next bit
        }
        return reversed;
    }

}
