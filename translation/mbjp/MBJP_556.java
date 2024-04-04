import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindOddPair {
    /**
     * * Write a Java function to count the pairs with xor as an odd number.
     *
     * > findOddPair([5, 4, 7, 2, 1], 5)
     * 6
     * > findOddPair([7, 2, 8, 1, 0, 5, 11], 7)
     * 12
     * > findOddPair([1, 2, 3], 3)
     * 2
     */
    public static int findOddPair(List<Integer> a, int n) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        int odds = 0;
        for (int i : a) {
            if ((i & 1) == 1) {
                odds++;
            }
        }
        return ((n + 1) * (odds - 1)) / 2;
    }
}