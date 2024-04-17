import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMonthnumber {
    /**
     * * Write a function to check whether the given month name contains 30 days or not.
     *
     * > checkMonthnumber("February")
     * false
     * > checkMonthnumber("June")
     * true
     * > checkMonthnumber("April")
     * true
     */
    public static Boolean checkMonthnumber(String monthname3) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < monthname3.length(); i++) {
            if (set.contains(Integer.valueOf(monthname3.charAt(i)))) {
                return false;
            }
            set.add(Integer.valueOf(monthname3.charAt(i)));
        }
        return true;
    }
}