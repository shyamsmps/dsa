package algo.binary;

/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 */
public class NumberOfSetBits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clear the least significant set bit
            count++;
        }
        return count;
    }

}
