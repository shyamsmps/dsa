package algo.dp;

/**
 * A child is running up a staircase with n steps and can hop either 1 step or 2 steps at a time.
 * Implement a function to count the number of possible ways that the child can run up the stairs.
 * 1,2 and 2,1 are two different ways.
 * Answers: 0-1, 1-1, 2-2, 3-3, 4-5, 5-8, 6-13, 7-21, 8-34
 * Formula: ways for n steps are: ways(n-1) + ways(n-2)
 * This is a Fibonacci series.
 *
 */
public class StaircaseWithTwoSteps {

    public static void main(String[] args) {
        int[] inputs = {0,1,2,3,4,5,6,7,8};
        int[] outputs = {0,1,2,3,5,8,13,21,34};
        for (int i : inputs) {
            System.out.println("[countWaysNoExtraSpace] Ways to reach " + i + " stairs: " + countWaysNoExtraSpace(i) + " pass: " + (countWaysNoExtraSpace(i) == outputs[i]));
            System.out.println("[countWaysRecursive] Ways to reach " + i + " stairs: " + countWaysRecursive(i) + " pass: " + (countWaysRecursive(i) == outputs[i]));
            System.out.println("[countWaysWithExtraSpace] Ways to reach " + i + " stairs: " + countWaysWithExtraSpace(i) + " pass: " + (countWaysWithExtraSpace(i) == outputs[i]));
        }
    }

    public static int countWaysNoExtraSpace(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int secondLast = 1; //ways to reach second last stair
        int last = 2; //ways to reach last stair
        int current = 0; //ways to reach current stair
        for (int i = 3; i <= n; i++) {
            current = last + secondLast; //summing ways to reach previous two stairs
            secondLast = last;
            last = current;
        }
        return current;
    }

    public static int countWaysRecursive(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return countWaysRecursive(n-1) + countWaysRecursive(n-2);
    }

    public static int countWaysWithExtraSpace(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] lookupTable = new int[n+1];
        lookupTable[0] = 1;
        lookupTable[1] = 1;
        for (int i = 2; i <= n; i++) {
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2];
        }
        return lookupTable[n];
    }


}
