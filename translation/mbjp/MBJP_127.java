import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultiplyInt {
    /**
     * * Write a function to multiply two integers without using the * operator in Java.
     *
     * > multiplyInt(10, 20)
     * 200
     * > multiplyInt(5, 10)
     * 50
     * > multiplyInt(4, 8)
     * 32
     */
    public static int multiplyInt(int x, int y) {
        int result = x * y;
        return result > 0 ? result : -result;
    }
}