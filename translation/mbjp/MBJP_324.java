import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfAlternates {
    /**
     * * Write a function to extract the sum of alternate chains of tuples.
     *
     * > sumOfAlternates([5, 6, 3, 6, 10, 34])
     * [46, 18]
     * > sumOfAlternates([1, 2, 3, 4, 5])
     * [6, 9]
     * > sumOfAlternates([6, 7, 8, 9, 4, 5])
     * [21, 18]
     */
    public static List<Integer> sumOfAlternates(List<Integer> testTuple) {
        List<Integer> sumOfAlternates = new ArrayList<Integer>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < testTuple.size(); i++) {
            if (i % 2 == 1) {
                sum1 += testTuple.get(i);
            } else {
                sum2 += testTuple.get(i);
            }
        }
        sumOfAlternates.add(sum1);
        sumOfAlternates.add(sum2);
        return sumOfAlternates;
    }
}