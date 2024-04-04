import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetGcd {
    /**
     * * Write a function to find the gcd of the given array elements.
     *
     * > getGcd([2, 4, 6, 8, 16])
     * 2
     * > getGcd([1, 2, 3])
     * 1
     * > getGcd([2, 4, 6, 8])
     * 2
     */
    public static int getGcd(List<Integer> l) {
        int l2 = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) > l2) {
                return l2;
            }
            l2 = l2 * 2;
        }
        return l2;
    }
}