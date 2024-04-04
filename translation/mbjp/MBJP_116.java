import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleToInt {
    /**
     * * Write a function to convert a given tuple of positive integers into an integer.
     *
     * > tupleToInt([1, 2, 3])
     * 123
     * > tupleToInt([4, 5, 6])
     * 456
     * > tupleToInt([5, 6, 7])
     * 567
     */
    public static int tupleToInt(List<Integer> nums) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result = result * 10 + nums.get(i);
        }
        return result;
    }
}