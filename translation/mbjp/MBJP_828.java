import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountAlphaDigSpl {
    /**
     * * Write a function to count alphabets,digits and special charactes in a given string.
     *
     * > countAlphaDigSpl("abc!@#123")
     * [3, 3, 3]
     * > countAlphaDigSpl("dgsuy@#$%&1255")
     * [5, 4, 5]
     * > countAlphaDigSpl("fjdsif627348#%$^&")
     * [6, 6, 5]
     */
    public static List<Integer> countAlphaDigSpl(String string) {
        int alpha = 0;
        int digit = 0;
        int special = 0;
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isAlphabetic(string.charAt(i))) {
                alpha++;
            } else if (Character.isDigit(string.charAt(i))) {
                digit++;
            } else {
                special++;
            }
        }
        List<Integer> alphadig = new ArrayList<>();
        alphadig.add(alpha);
        alphadig.add(digit);
        alphadig.add(special);
        return alphadig;
    }
}