import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchThree {
    /**
     * * Write a function that matches a string that has an a followed by three 'b'.
     *
     * > textMatchThree("ac")
     * "Not matched!"
     * > textMatchThree("dc")
     * "Not matched!"
     * > textMatchThree("abbbba")
     * "Found a match!"
     */
    public static String textMatchThree(String text) {
        if (text.length() < 3) {
            return "Not matched!";
        }
        int a = 0;
        int b = 1;
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == 'a') {
                a++;
            } else {
                if (a == 0) {
                    b = 0;
                } else {
                    if (b == 1) {
                        a--;
                        b = 0;
                    } else {
                        a--;
                    }
                }
            }
        }
        if (a == 0) {
            return "Found a match!";
        }
        return "Not matched!";
    }
}