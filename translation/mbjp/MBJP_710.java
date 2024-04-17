import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FrontAndRear {
    /**
     * * Write a function to access the initial and last data of the given tuple record.
     *
     * > frontAndRear([10, 4, 5, 6, 7])
     * [10, 7]
     * > frontAndRear([1, 2, 3, 4, 5])
     * [1, 5]
     * > frontAndRear([6, 7, 8, 9, 10])
     * [6, 10]
     */
    public static List<Integer> frontAndRear(List<Integer> testTup) {
        List<Integer> result = new ArrayList<>();
        int init = testTup.get(0);
        int last = testTup.get(testTup.size() - 1);

        result.add(init);
        result.add(last);
        return result;
    }
}