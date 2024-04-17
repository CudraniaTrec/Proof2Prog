import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortString {
    /**
     * * Write a Java function to sort the given string.
     *
     * > sortString("cba")
     * "abc"
     * > sortString("data")
     * "aadt"
     * > sortString("zxy")
     * "xyz"
     */
    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}