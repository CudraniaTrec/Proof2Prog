import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMonthnumNumber {
    /**
     * * Write a function to check whether the given month number contains 28 days or not.
     *
     * > checkMonthnumNumber(2)
     * true
     * > checkMonthnumNumber(1)
     * false
     * > checkMonthnumNumber(3)
     * false
     */
    public static Boolean checkMonthnumNumber(int monthnum1) {
        switch (monthnum1) {
            case 2:
            case 4:
            case 6:
            case 9:
            case 11:
                return true;
            default:
                return false;
        }
    }
}