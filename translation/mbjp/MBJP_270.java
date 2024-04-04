import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumEvenAndEvenIndex {
    /**
     * * Write a Java function to find the sum of even numbers at even positions.
     *
     * > sumEvenAndEvenIndex([5, 6, 12, 1, 18, 8], 6)
     * 30
     * > sumEvenAndEvenIndex([3, 20, 17, 9, 2, 10, 18, 13, 6, 18], 10)
     * 26
     * > sumEvenAndEvenIndex([5, 6, 12, 1], 4)
     * 12
     */
    public static int sumEvenAndEvenIndex(List<Integer> arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i += 2) {
            if (arr.get(i) % 2 == 0) {
                sum += arr.get(i);
            }
        }
        return sum;
    }
}