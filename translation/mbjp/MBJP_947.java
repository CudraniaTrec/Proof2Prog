import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LenLog {
    /**
     * * Write a Java function to find the length of the shortest word.
     *
     * > lenLog(["win", "lose", "great"])
     * 3
     * > lenLog(["a", "ab", "abc"])
     * 1
     * > lenLog(["12", "12", "1234"])
     * 2
     */
    public static int lenLog(List<String> list1) {
        int l = 0;
        String temp = null;
        for (String s : list1) {
            if (temp == null) {
                temp = s;
            } else {
                if (temp.length() > l) {
                    l = temp.length();
                    temp = null;
                }
            }
        }
        return l;
    }
}