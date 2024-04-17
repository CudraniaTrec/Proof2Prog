import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfPrimes {
    /**
     * * Write a Java function to find sum of prime numbers between 1 to n.
     *
     * > sumOfPrimes(10)
     * 17
     * > sumOfPrimes(20)
     * 77
     * > sumOfPrimes(5)
     * 10
     */
    public static int sumOfPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n+1; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                res += i;
            }
        }
        return res;
    }
}