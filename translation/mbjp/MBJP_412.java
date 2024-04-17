import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveOdd {
    /**
     * * Write a Java function to remove odd numbers from a given list.
     *
     * > removeOdd([1, 2, 3])
     * [2]
     * > removeOdd([2, 4, 6])
     * [2, 4, 6]
     * > removeOdd([10, 20, 3])
     * [10, 20]
     */
    public static List<Integer> removeOdd(List<Integer> l) {
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) % 2 == 0) {
                r.add(l.get(i));
            }
        }
        return r;
    }
}