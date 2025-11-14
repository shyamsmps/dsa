package algo.arrays_strings;


/*
You are given a binary string `s` (a string containing only "0" and "1"). 
You may choose up to one "0" and flip it to a "1". 
 */
public class SlidingWindow_MaxConsecutive1sAfterFlipping0 {

    public static void main(String[] args) {
        String[] inputs = {"11001011", "0000", "1111", "101010", "1000111001", "010", "001110011", "10111101", "1", "0"};
        int[] outputs = {4, 1, 4, 3, 4, 2, 4, 6, 1, 1};
        for (int i=0; i<inputs.length; i++) {
            String input = inputs[i];
            int output = outputs[i], result = withSlidingWindow(input);
            System.out.println(String.format("pass: %s, input: %s, expected: %s, actual: %s", 
                (output == result), input, output, result));
        }
    }

    private static int withSlidingWindow(String str) {
        int result=0, flipped = -1, left=0;
        for (int right=0; right < str.length(); right++) {
            char cRight = str.charAt(right);
            if (cRight == '0') {
                if (flipped>=0) {
                    // invalid substring, reset left to (last zero + 1)
                    // some people do a while loop as well if two zeros are found, but we can store the index and directly jump to last zero
                    left = flipped+1;
                }
                flipped=right;
            }
            result = Math.max(result, (right-left+1));
        }
        return result;
    }

}
