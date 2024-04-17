import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckOddParity {
    /**
     * * Write a Java function to check for odd parity of a given number.
     *
     * > checkOddParity(13)
     * true
     * > checkOddParity(21)
     * true
     * > checkOddParity(18)
     * false
     */
    public static Boolean checkOddParity(int x) {
        boolean res = false;
        for (int i = 0; i < x; i++) {
            res = (x % 2) == 1;
        }
        return res;
    }
}