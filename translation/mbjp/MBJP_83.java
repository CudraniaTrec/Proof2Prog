import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetChar {
    /**
     * * Write a Java function to find the character made by adding all the characters of the given string.
     *
     * > getChar("abc")
     * "f"
     * > getChar("gfg")
     * "t"
     * > getChar("ab")
     * "c"
     */
    public static String getChar(String strr) {
        if (strr == null || strr.length() == 0) {
            return "";
        }
        int sum = 0;
        for (int i = 0; i < strr.length(); i++) {
            sum += (strr.charAt(i) - 'a' + 1);
        }
        String result = "";
        while (sum > 0) {
            result += (char) ((sum - 1) % 26 + 'a');
            sum /= 26;
        }
        return result;
    }
}