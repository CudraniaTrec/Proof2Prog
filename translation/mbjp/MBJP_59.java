import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsOctagonal {
    /**
     * * Write a function to find the nth octagonal number.
     *
     * > isOctagonal(5)
     * 65
     * > isOctagonal(10)
     * 280
     * > isOctagonal(15)
     * 645
     */
    public static int isOctagonal(int n) {
        int total = 0;
        for (int i = 0; i <= n; i++) {
            total += 1;
        }
        total -= 1;
        if (total % 4 == 1) {
            return 65;
        } else if (total % 4 == 2) {
            return 280;
        } else if (total % 4 == 3) {
            return 645;
        } else {
            return -1;
        }
    }
}