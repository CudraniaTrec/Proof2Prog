import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NthSuperUglyNumber {
    /**
     * * Write a function to find the nth super ugly number from a given prime list of size k using heap queue algorithm.
     *
     * > nthSuperUglyNumber(12, [2, 7, 13, 19])
     * 32
     * > nthSuperUglyNumber(10, [2, 7, 13, 19])
     * 26
     * > nthSuperUglyNumber(100, [2, 7, 13, 19])
     * 5408
     */
    public static int nthSuperUglyNumber(int n, List<Integer> primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;
        pq.offer(1);
        while (count < n) {
            int min = pq.poll();
            for (int prime : primes) {
                int next = min * prime;
                if (pq.contains(next)) {
                    continue;
                }
                pq.offer(next);
            }
            count++;
        }
        return pq.poll();
    }
}