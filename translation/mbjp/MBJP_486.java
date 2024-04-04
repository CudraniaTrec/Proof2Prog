import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BinomialProbability {
    /**
     * * Write a function to compute binomial probability for the given number.
     *
     * > binomialProbability(10, 5, 0.3333333333333333)
     * 0.13656454808718185
     * > binomialProbability(11, 6, 0.5)
     * 0.2255859375
     * > binomialProbability(12, 7, 0.6)
     * 0.227030335488
     */
    public static Double binomialProbability(int n, int k, Double p) {
        double sum = 1;
        for (int i = 0; i < k; i++) {
            sum = sum * (n - i) / (i + 1);
        }
        return sum * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }
}