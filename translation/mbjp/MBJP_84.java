import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Sequence {
    /**
     * * Write a function to find the n-th number in newman conway sequence.
     *
     * > sequence(10)
     * 6
     * > sequence(2)
     * 1
     * > sequence(3)
     * 2
     */
    public static int sequence(int n) {
        int result = 0;
        while (n > 1) {
            result += 1;
            if (result > n) {
                return result;
            }
            n -= 1;
        }
        return result;
    }
}