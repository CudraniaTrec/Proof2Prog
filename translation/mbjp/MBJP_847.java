import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Lcopy {
    /**
     * * Write a Java function to copy a list from a singleton tuple.
     *
     * > lcopy([1, 2, 3])
     * [1, 2, 3]
     * > lcopy([4, 8, 2, 10, 15, 18])
     * [4, 8, 2, 10, 15, 18]
     * > lcopy([4, 5, 6])
     * [4, 5, 6]
     */
    public static List<Integer> lcopy(List<Integer> xs) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < xs.size(); i++) {
            if (xs.get(i) != null) {
                output.add(xs.get(i).intValue());
            }
        }
        return output;
    }
}