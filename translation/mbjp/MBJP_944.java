import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NumPosition {
    /**
     * * Write a function to separate and print the numbers and their position of a given string.
     *
     * > numPosition("there are 70 flats in this apartment")
     * 10
     * > numPosition("every adult have 32 teeth")
     * 17
     * > numPosition("isha has 79 chocolates in her bag")
     * 9
     */
    public static int numPosition(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}