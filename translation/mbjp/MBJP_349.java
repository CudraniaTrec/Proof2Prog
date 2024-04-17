import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Check {
    /**
     * * Write a Java function to check whether the given string is a binary string or not.
     *
     * > check("01010101010")
     * "Yes"
     * > check("name0")
     * "No"
     * > check("101")
     * "Yes"
     */
    public static String check(String string) {
        if (string.length() == 0) {
            return "No";
        }
        if (string.matches("^\\d+$")) {
            return "Yes";
        }
        if (string.matches("^\\d+$")) {
            return "No";
        }
        if (string.matches("^\\d+$")) {
            return "Yes";
        }
        if (string.matches("^\\d+$")) {
            return "No";
        }
        return "No";
    }
}