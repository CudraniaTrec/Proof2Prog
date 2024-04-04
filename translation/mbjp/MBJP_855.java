import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckEvenParity {
    /**
     * * Write a Java function to check for even parity of a given number.
     *
     * > checkEvenParity(10)
     * true
     * > checkEvenParity(11)
     * false
     * > checkEvenParity(18)
     * true
     */
    public static Boolean checkEvenParity(int x) {
        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}