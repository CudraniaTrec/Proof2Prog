import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMonthnum {
    /**
     * * Write a function to check whether the given month name contains 28 days or not.
     *
     * > checkMonthnum("February")
     * true
     * > checkMonthnum("January")
     * false
     * > checkMonthnum("March")
     * false
     */
    public static Boolean checkMonthnum(String monthname1) {
        String[] month = monthname1.split(" ");
        boolean isAfter30 = false;
        for (String monthnum : month) {
            if (monthnum.equals("February")) {
                isAfter30 = true;
            } else if (monthnum.equals("January")) {
                isAfter30 = false;
            }
        }
        return isAfter30;
    }
}