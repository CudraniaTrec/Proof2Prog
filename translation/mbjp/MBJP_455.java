import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMonthnumbNumber {
    /**
     * * Write a function to check whether the given month number contains 31 days or not.
     *
     * > checkMonthnumbNumber(5)
     * true
     * > checkMonthnumbNumber(2)
     * false
     * > checkMonthnumbNumber(6)
     * false
     */
    public static Boolean checkMonthnumbNumber(int monthnum2) {
        int year = 1900;
        int month = 0;
        int day = 0;
        while (month < monthnum2 && day < 12) {
            month += 1;
            day += 1;
        }
        if (day > 12) {
            return false;
        }
        if (month == 2 && month == 6) {
            return false;
        }
        return (monthnum2 - 1) % 2 == 0;
    }
}