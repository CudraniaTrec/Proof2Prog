import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMonthnumberNumber {
    /**
     * * Write a function to check whether the given month number contains 30 days or not.
     *
     * > checkMonthnumberNumber(6)
     * true
     * > checkMonthnumberNumber(2)
     * false
     * > checkMonthnumberNumber(12)
     * false
     */
    public static Boolean checkMonthnumberNumber(int monthnum3) {
        if (monthnum3 < 6) {
            return false;
        }
        else if (monthnum3 < 12) {
            return true;
        }
        else {
            return false;
        }
    }
}