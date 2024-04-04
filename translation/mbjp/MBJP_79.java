import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class WordLen {
    /**
     * * Write a Java function to check whether the length of the word is odd or not.
     *
     * > wordLen("Hadoop")
     * false
     * > wordLen("great")
     * true
     * > wordLen("structure")
     * true
     */
    public static Boolean wordLen(String s) {
        int len = s.length();
        return len % 2 == 1;
    }
}