import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SameOrder {
    /**
     * * Write a function to check if the common elements between two given lists are in the same order or not.
     *
     * > sameOrder(["red", "green", "black", "orange"], ["red", "pink", "green", "white", "black"])
     * true
     * > sameOrder(["red", "pink", "green", "white", "black"], ["white", "orange", "pink", "black"])
     * false
     * > sameOrder(["red", "green", "black", "orange"], ["red", "pink", "green", "white", "black"])
     * true
     */
    public static Boolean sameOrder(List<String> l1, List<String> l2) {
        if (l1 == null || l2 == null) {
            return false;
        }

        List<String> l1s = Arrays.asList(l1.get(0));
        List<String> l2s = Arrays.asList(l2.get(0));
        if (l1s.containsAll(l2s)) {
            return true;
        }
        return false;
    }
}