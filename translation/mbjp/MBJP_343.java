import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DigLet {
    /**
     * * Write a function to calculate the number of digits and letters in a string.
     *
     * > digLet("python")
     * [6, 0]
     * > digLet("program")
     * [7, 0]
     * > digLet("python3.0")
     * [6, 2]
     */
    public static List<Integer> digLet(String s) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                count++;
            }
        }
        ans.add(count);
        count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        ans.add(count);
        return ans;
    }
}