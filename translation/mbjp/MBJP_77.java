import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsDiff {
    /**
     * * Write a Java function to find the difference between sum of even and odd digits.
     *
     * > isDiff(1212112)
     * true
     * > isDiff(1212)
     * false
     */
    public static Boolean isDiff(int n) {
        String nStr = Integer.toString(n);
        String sStr = nStr + "";
        if (sStr.length() % 2 == 0) {
            return false;
        }
        if (nStr.length() % 2 == 1) {
            return true;
        }
        boolean result = (sStr.length() % 2 == 0 && sStr.length() != 0);
        return result;
    }
}