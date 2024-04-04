import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleToFloat {
    /**
     * * Write a function to convert the given tuple to a floating-point number.
     *
     * > tupleToFloat([4, 56])
     * 4.56
     * > tupleToFloat([7, 256])
     * 7.256
     * > tupleToFloat([8, 123])
     * 8.123
     */
    public static Double tupleToFloat(List<Integer> testTup) {
        if (testTup.size() != 3) {
            System.out.println("Invalid Input!");
            System.exit(0);
        }
        int value = testTup.get(0);
        int max = (int) Math.pow(2, testTup.size());
        return (double) value / max;
    }
}