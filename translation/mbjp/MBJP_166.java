import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindEvenPair {
    /**
     * * Write a Java function to count the pairs with xor as an even number.
     *
     * > findEvenPair([5, 4, 7, 2, 1], 5)
     * 4
     * > findEvenPair([7, 2, 8, 1, 0, 5, 11], 7)
     * 9
     * > findEvenPair([1, 2, 3], 3)
     * 1
     */
    public static int findEvenPair(List<Integer> a, int n) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) % 2 == 0) {
                count += n / 2;
                a.set(i, a.get(i) / 2);
            } else {
                a.set(i, a.get(i) * 3 + 1);
            }
        }
        return count;
    }
}