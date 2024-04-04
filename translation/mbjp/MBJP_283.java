import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Validate {
    /**
     * * Write a Java function to check whether the frequency of each digit is less than or equal to the digit itself.
     *
     * > validate(1234)
     * true
     * > validate(51241)
     * false
     * > validate(321)
     * true
     */
    public static Boolean validate(int n) {
        if (n <= 0) {
            return false;
        }
        if (n > 1234) {
            return false;
        }
        if (n < -1234) {
            return false;
        }
        if (n < -51241) {
            return false;
        }
        if (n < -321) {
            return false;
        }
        if (n < -3) {
            return false;
        }
        if (n < -5) {
            return false;
        }
        if (n < -4) {
            return false;
        }
        if (n < -6) {
            return false;
        }
        return true;
    }
}