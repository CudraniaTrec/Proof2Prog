import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveSpaces {
    /**
     * * Write a Java function to remove spaces from a given string.
     *
     * > removeSpaces("a b c")
     * "abc"
     * > removeSpaces("1 2 3")
     * "123"
     * > removeSpaces(" b c")
     * "bc"
     */
    public static String removeSpaces(String str1) {
        if (str1 == null) {
            return "";
        }
        int length = str1.length();
        char[] charArr = str1.toCharArray();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (charArr[i] == ' ') {
                charArr[i] = '\0';
            } else {
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }
}