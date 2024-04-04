import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DifferAtOneBitPos {
    /**
     * * Write a Java function to check whether the two numbers differ at one bit position only or not.
     *
     * > differAtOneBitPos(13, 9)
     * true
     * > differAtOneBitPos(15, 8)
     * false
     * > differAtOneBitPos(2, 4)
     * false
     */
    public static Boolean differAtOneBitPos(int a, int b) {
        int diff = a ^ b;
        int count = 0;
        while (diff > 0) {
            diff = diff & (diff - 1);
            count++;
        }
        return count == 1;
    }
}