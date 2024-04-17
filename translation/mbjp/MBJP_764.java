import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NumberCtr {
    /**
     * * Write a Java function to count numeric values in a given string.
     *
     * > numberCtr("program2bedone")
     * 1
     * > numberCtr("3wonders")
     * 1
     * > numberCtr("123")
     * 3
     */
    public static int numberCtr(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch) || ch == '-') {
                result++;
            }
        }
        return result;
    }
}