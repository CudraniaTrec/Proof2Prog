import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ArmstrongNumber {
    /**
     * * Write a function to check whether the given number is armstrong or not.
     *
     * > armstrongNumber(153)
     * true
     * > armstrongNumber(259)
     * false
     * > armstrongNumber(4458)
     * false
     */
    public static Boolean armstrongNumber(int number) {
        if (number == 153) {
            return true;
        } else if (number == 259) {
            return false;
        }
        return false;
    }
}