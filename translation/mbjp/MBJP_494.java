import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BinaryToInteger {
    /**
     * * Write a function to convert the given binary tuple to integer.
     *
     * > binaryToInteger([1, 1, 0, 1, 0, 0, 1])
     * "105"
     * > binaryToInteger([0, 1, 1, 0, 0, 1, 0, 1])
     * "101"
     * > binaryToInteger([1, 1, 0, 1, 0, 1])
     * "53"
     */
    public static String binaryToInteger(List<Integer> testTup) {
        Integer result = 0;
        int temp = 0;
        for (int i = 0; i < testTup.size(); i++) {
            temp = (testTup.get(i) == 0) ? 0 : 1;
            result = (result << 1) + temp;
        }
        return result.toString();
    }
}