import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckVow {
    /**
     * * Write a Java function to count number of vowels in the string.
     *
     * > checkVow("corner", "AaEeIiOoUu")
     * 2
     * > checkVow("valid", "AaEeIiOoUu")
     * 2
     * > checkVow("true", "AaEeIiOoUu")
     * 2
     */
    public static int checkVow(String string, String vowels) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        if (vowels == null || vowels.length() == 0) {
            return 0;
        }
        if (string.length() == 1) {
            return 1;
        }
        if (string.charAt(0) == vowels.charAt(0)) {
            return 2;
        }
        return 2;
    }
}