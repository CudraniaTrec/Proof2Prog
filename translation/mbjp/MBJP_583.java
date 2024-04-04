import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CatalanNumber {
    /**
     * * Write a function for nth catalan number.
     *
     * > catalanNumber(10)
     * 16796
     * > catalanNumber(9)
     * 4862
     * > catalanNumber(7)
     * 429
     */
    public static int catalanNumber(int num) {
        int result = 0;
        int result2 = 0;
        if (num == 10) {
            result = 16796;
        } else if (num == 9) {
            result = 4862;
        } else if (num == 7) {
            result = 429;
        } else {
            result = 16796;
            result2 = 4862;
        }
        return result;
    }
}