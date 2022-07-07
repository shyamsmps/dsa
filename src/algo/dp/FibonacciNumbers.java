package algo.dp;

/**
 *  Java function that returns nth the Fibonacci number
 */
public class FibonacciNumbers {

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144

    public static void main(String[] args) {

        System.out.println(fibonacciLinearTabulation(3) == 1);
        System.out.println(fibonacciLinearTabulation(8) == 13);
        System.out.println(fibonacciLinearTabulation(10) == 34);
        System.out.println(fibonacciLinearTabulation(13) == 144);

    }

    public static int fibonacciRecursion(int n) {
        if (n==1) {
            return 0;
        } else if (n==2) {
            return 1;
        } else {
            return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
        }
    }

    public static int fibonacciLinearNoRecursion(int n) {
        int a=0;
        int b=1;
        int temp;
        if (n<=2) {
            return n-1;
        } else {
            for (int i=3; i<=n; i++) {
                temp = b;
                b=a+b;
                a=temp;
            }
            return b;
        }
    }

    public static int fibonacciLinearTabulation(int n)
    {
        int[] lookupTable = new int[n];
        lookupTable[0] = 0;
        lookupTable[1] = 1;

        for (int i = 3; i <= n; i++)
            lookupTable[i-1] = lookupTable[i-2] + lookupTable[i-3]; // Fill up the table by summing up previous two values

        return lookupTable[n-1]; // Return the nth Fibonacci number
    }

}