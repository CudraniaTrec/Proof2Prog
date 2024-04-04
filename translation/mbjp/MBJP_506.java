import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PermutationCoefficient {
    /**
     * * Write a function to calculate the permutation coefficient of given p(n, k).
     *
     * > permutationCoefficient(10, 2)
     * 90
     * > permutationCoefficient(10, 3)
     * 720
     * > permutationCoefficient(10, 1)
     * 10
     */
    public static int permutationCoefficient(int n, int k) {
        int sum = 1;
        for (int i = 1; i <= k; i++) {
            sum *= n - i + 1;
        }
        return sum;
    }
}