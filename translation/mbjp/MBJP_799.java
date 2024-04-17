import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LeftRotate {
    /**
     * * Write a Java function to left rotate the bits of a given number.
     *
     * > leftRotate(16, 2)
     * 64
     * > leftRotate(10, 2)
     * 40
     * > leftRotate(99, 3)
     * 792
     */
    public static int leftRotate(int n, int d) {
        return n << d;
    }
}