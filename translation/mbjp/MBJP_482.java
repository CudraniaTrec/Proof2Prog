import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Match {
    /**
     * * Write a function to find sequences of one upper case letter followed by lower case letters in the given string by using regex.
     *
     * > match("Geeks")
     * "Yes"
     * > match("geeksforGeeks")
     * "Yes"
     * > match("geeks")
     * "No"
     */
    public static String match(String text) {
        int i = 0, j = 0;
        String res = "No";
        while (i < text.length() && j < text.length()) {
            if (Character.isLowerCase(text.charAt(i))) {
                while (i < text.length() && Character.isLowerCase(text.charAt(i)))
                    i++;
            } else if (Character.isUpperCase(text.charAt(j))) {
                while (j < text.length() && Character.isUpperCase(text.charAt(j)))
                    j++;
            } else {
                i++;
                j++;
            }
            if (i < text.length() && j < text.length() && text.substring(i, i + 1).equals(text.substring(j, j + 1))) {
                res = "Yes";
            }
        }
        return res;
    }
}