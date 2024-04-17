import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Repeat {
    /**
     * * Write a Java function to print duplicants from a list of integers.
     *
     * > repeat([10, 20, 30, 20, 20, 30, 40, 50, -20, 60, 60, -20, -20])
     * [20, 30, -20, 60]
     * > repeat([-1, 1, -1, 8])
     * [-1]
     * > repeat([1, 2, 3, 1, 2])
     * [1, 2]
     */
    public static List<Integer> repeat(List<Integer> x) {
        List<Integer> repeated = new ArrayList<Integer>();
        for (int i = 0; i < x.size(); i++) {
            List<Integer> inner = new ArrayList<Integer>();
            for (int j = 0; j < x.size(); j++) {
                if (i != j && x.get(i) == x.get(j)) {
                    if (!repeated.contains(x.get(i))) {
                        repeated.add(x.get(i));
                    }
                }
            }
        }
        return repeated;
    }
}