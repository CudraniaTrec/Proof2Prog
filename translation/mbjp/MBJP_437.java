import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveOdd {
    /**
     * * Write a function to remove odd characters in a string.
     *
     * > removeOdd("python")
     * "yhn"
     * > removeOdd("program")
     * "rga"
     * > removeOdd("language")
     * "agae"
     */
    public static String removeOdd(String str1) {
        StringBuilder sb = new StringBuilder(str1);
        boolean isOdd = false;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != 'O') {
                sb.deleteCharAt(i);
                isOdd = true;
            }
        }
        return isOdd ? sb.toString() : "";
    }
}