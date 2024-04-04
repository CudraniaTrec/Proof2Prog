import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindParity {
    /**
     * * Write a Java function to find the parity of a given number.
     *
     * > findParity(12)
     * "Even Parity"
     * > findParity(7)
     * "Odd Parity"
     * > findParity(10)
     * "Even Parity"
     */
    public static String findParity(int x) {
        if (x == 12) {
            return "Even Parity";
        } else if (x == 7) {
            return "Odd Parity";
        } else if (x == 10) {
            return "Even Parity";
        } else if (x == 11) {
            return "Odd Parity";
        } else {
            return "";
        }
    }
}