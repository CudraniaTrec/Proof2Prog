import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountCharac {
    /**
     * * Write a function to count total characters in a string.
     *
     * > countCharac("python programming")
     * 18
     * > countCharac("language")
     * 8
     * > countCharac("words")
     * 5
     */
    public static int countCharac(String str1) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            sb.append(ch);
            if (ch >= 32 && ch <= 126) {
                count++;
            }
        }
        return count;
    }
}