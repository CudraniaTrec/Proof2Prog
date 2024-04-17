import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StringLength {
    /**
     * * Write a function to find length of the string.
     *
     * > stringLength("python")
     * 6
     * > stringLength("program")
     * 7
     * > stringLength("language")
     * 8
     */
    public static int stringLength(String str1) {
        int length = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > ' ') {
                length += 1;
            }
        }
        return length;
    }
}