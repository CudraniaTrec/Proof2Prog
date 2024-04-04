import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountInteger {
    /**
     * * Write a Java function to count integers from a given list.
     *
     * > countInteger([1, 2, "abc", 1.2])
     * 2
     * > countInteger([1, 2, 3])
     * 3
     * > countInteger([1, 1.2, 4, 5.1])
     * 2
     */
    public static int countInteger(List<Object> list1) {
        int count = 0;
        for (Object o : list1) {
            if (o instanceof Integer) {
                count++;
            }
        }
        return count;
    }
}