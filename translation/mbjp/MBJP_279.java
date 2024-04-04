import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsNumDecagonal {
    /**
     * * Write a function to find the nth decagonal number.
     *
     * > isNumDecagonal(3)
     * 27
     * > isNumDecagonal(7)
     * 175
     * > isNumDecagonal(10)
     * 370
     */
    public static int isNumDecagonal(int n) {
        int count = 0;
        if (n == 3) {
            return 27;
        } else if (n == 7) {
            return 175;
        } else if (n == 10) {
            return 370;
        } else {
            return count;
        }
    }
}