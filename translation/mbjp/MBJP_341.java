import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SetToTuple {
    /**
     * * Write a function to convert the given set into tuples.
     *
     * > setToTuple({1, 2, 3, 4, 5})
     * [1, 2, 3, 4, 5]
     * > setToTuple({6, 7, 8, 9, 10, 11})
     * [6, 7, 8, 9, 10, 11]
     * > setToTuple({12, 13, 14, 15, 16})
     * [12, 13, 14, 15, 16]
     */
    public static List<Integer> setToTuple(HashSet<Integer> s) {
        ArrayList<Integer> rt = new ArrayList<>();
        for (Integer n: s) {
            rt.add(n);
        }
        Collections.sort(rt);
        return rt;
    }
}