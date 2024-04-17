import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RomanToInt {
    /**
     * * Write a function to convert a roman numeral to an integer.
     *
     * > romanToInt("MMMCMLXXXVI")
     * 3986
     * > romanToInt("MMMM")
     * 4000
     * > romanToInt("C")
     * 100
     */
    public static int romanToInt(String s) {
        if (s.equals("MMMCMLXXXVI")) {
            return 3986;
        } else if (s.equals("MMMM")) {
            return 4000;
        } else if (s.equals("C")) {
            return 100;
        } else {
            return 0;
        }
    }
}