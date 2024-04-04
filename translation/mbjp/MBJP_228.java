import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AllBitsSetInTheGivenRange {
    /**
     * * Write a Java function to check whether all the bits are unset in the given range or not.
     *
     * > allBitsSetInTheGivenRange(4, 1, 2)
     * true
     * > allBitsSetInTheGivenRange(17, 2, 4)
     * true
     * > allBitsSetInTheGivenRange(39, 4, 6)
     * false
     */
    public static Boolean allBitsSetInTheGivenRange(int n, int l, int r) {
        if (n == l || n == r) {
            return true;
        }
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        while (n != 0) {
            for (int i = 0; i <= l; i++) {
                if (set.contains(i)) {
                    return false;
                }
                set.add(i);
            }
            n &= r;
            count++;
        }
        return count == 1;
    }
}