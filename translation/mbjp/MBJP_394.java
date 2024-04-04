import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckDistinct {
    /**
     * * Write a function to check if given tuple is distinct or not.
     *
     * > checkDistinct([1, 4, 5, 6, 1, 4])
     * false
     * > checkDistinct([1, 4, 5, 6])
     * true
     * > checkDistinct([2, 3, 4, 5, 6])
     * true
     */
    public static Boolean checkDistinct(List<Integer> testTup) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (Integer i : testTup) {
            if (hs.contains(i)) {
                return false;
            }
            hs.add(i);
        }
        return true;
    }
}