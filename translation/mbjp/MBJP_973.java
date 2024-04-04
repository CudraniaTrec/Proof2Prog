import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LeftRotate {
    /**
     * * Write a Java function to left rotate the string.
     *
     * > leftRotate("python", 2)
     * "thonpy"
     * > leftRotate("bigdata", 3)
     * "databig"
     * > leftRotate("hadoop", 1)
     * "adooph"
     */
    public static String leftRotate(String s, int d) {
        return s.substring(d) + s.substring(0, d);
    }
}