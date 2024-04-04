import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveEven {
    /**
     * * Write a function to remove even characters in a string.
     *
     * > removeEven("python")
     * "pto"
     * > removeEven("program")
     * "porm"
     * > removeEven("language")
     * "lnug"
     */
    public static String removeEven(String str1) {
        String str2 = "";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                str2 = str2 + chars[i];
            }
        }
        return str2;
    }
}