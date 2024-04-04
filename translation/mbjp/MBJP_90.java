import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LenLog {
    /**
     * * Write a Java function to find the length of the longest word.
     *
     * > lenLog(["python", "PHP", "bigdata"])
     * 7
     * > lenLog(["a", "ab", "abc"])
     * 3
     * > lenLog(["small", "big", "tall"])
     * 5
     */
    public static int lenLog(List<String> list1) {
        int len = 0;
        for (String str : list1) {
            len = Math.max(len, str.length());
        }
        return len;
    }
}