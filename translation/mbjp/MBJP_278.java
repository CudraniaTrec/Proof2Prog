import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountFirstElements {
    /**
     * * Write a function to find the element count that occurs before the record in the given tuple.
     *
     * > countFirstElements([1, 5, 7, [4, 6], 10])
     * 3
     * > countFirstElements([2, 9, [5, 7], 11])
     * 2
     * > countFirstElements([11, 15, 5, 8, [2, 3], 8])
     * 4
     */
    public static int countFirstElements(List<Object> testTup) {
        if (testTup.get(0) instanceof Integer) {
            int count = 0;
            for (int i = 0; i < testTup.size(); i++) {
                if (i != 0 && testTup.get(i) instanceof List) {
                    return count;
                }
                if (testTup.get(i) instanceof Integer) {
                    count++;
                }
            }
            return count;
        }
        return -1;
    }
}