import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddValuesString {
    /**
     * * Write a Java function to remove the characters which have odd index values of a given string.
     *
     * > oddValuesString("abcdef")
     * "ace"
     * > oddValuesString("python")
     * "pto"
     * > oddValuesString("data")
     * "dt"
     */
    public static String oddValuesString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] strs = str.split("");
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i % 2 == 0) {
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}