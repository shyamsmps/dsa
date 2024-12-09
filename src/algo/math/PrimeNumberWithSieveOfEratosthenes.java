package algo.math;

import java.util.Arrays;

public class PrimeNumberWithSieveOfEratosthenes {

    public static void main(String[] args) {
        int n = 10;
        boolean[] isPrime = isPrime(n);
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] isPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        // Initialize all numbers as prime
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // use sieve of eratosthenes to find prime numbers
        // we only need to check up to the square root of 𝑛.
        // If a number has a factor greater than its square root, it would have already been marked as non-prime by a smaller factor
        for (int i = 2; i*i < n; i++) {
            System.out.println("i: " + i);
            // skip if already marked as non-prime. it means this as well as all its multiples are already marked as non-prime.
            if (isPrime[i]) {
                // We start from i×i because all smaller multiples of i (like i×2,i×3, etc.) have already been marked as non-prime by smaller factors.
                // j += i increments by 𝑖 i each time, marking each multiple of 𝑖 i as false in isPrime, meaning these numbers are non-prime.
                // basically we are marking all multiples of i as non-prime
                for (int j = i*i; j <= n; j += i) {
                    System.out.println("j: " + j);
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;

    }

}
