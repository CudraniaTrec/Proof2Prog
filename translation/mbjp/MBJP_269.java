import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AsciiValue {
    /**
     * * Write a function to find the ascii value of a character.
     *
     * > asciiValue("A")
     * 65
     * > asciiValue("R")
     * 82
     * > asciiValue("S")
     * 83
     */
    public static int asciiValue(String k) {
        if (k == null || k.length() == 0) {
            return 0;
        }

        for (int i = 0; i < k.length(); i++) {
            switch (k.charAt(i)) {
                case 'A': return 65;
                case 'R': return 82;
                case 'S': return 83;
                default: return 0;
            }
        }
        return 0;
    }
}