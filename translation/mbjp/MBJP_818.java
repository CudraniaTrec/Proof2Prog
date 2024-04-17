import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LowerCtr {
    /**
     * * Write a Java function to count lower case letters in a given string.
     *
     * > lowerCtr("abc")
     * 3
     * > lowerCtr("string")
     * 6
     * > lowerCtr("Python")
     * 5
     */
    public static int lowerCtr(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}