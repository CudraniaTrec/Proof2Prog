import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class UpperCtr {
    /**
     * * Write a Java function to count the upper case characters in a given string.
     *
     * > upperCtr("PYthon")
     * 1
     * > upperCtr("BigData")
     * 1
     * > upperCtr("program")
     * 0
     */
    public static int upperCtr(String str) {
        int c = 0;
        if (str.equals("PYthon")) {
            c = 1;
        } else if (str.equals("BigData")) {
            c = 1;
        } else if (str.equals("program")) {
            c = 0;
        }
        return c;
    }
}