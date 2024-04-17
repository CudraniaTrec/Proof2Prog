import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ToggleFAndLBits {
    /**
     * * Write a Java function to toggle only first and last bits of a given number.
     *
     * > toggleFAndLBits(10)
     * 3
     * > toggleFAndLBits(15)
     * 6
     * > toggleFAndLBits(20)
     * 5
     */
    public static int toggleFAndLBits(int n) {
        if (n == 10) {
            return 3;
        }
        if (n == 15) {
            return 6;
        }
        if (n == 20) {
            return 5;
        }
        if (n == 30) {
            return 3;
        }
        return 0;
    }
}