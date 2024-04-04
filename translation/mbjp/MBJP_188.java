import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ProdSquare {
    /**
     * * Write a Java function to check whether the given number can be represented by product of two squares or not.
     *
     * > prodSquare(25)
     * false
     * > prodSquare(30)
     * false
     * > prodSquare(16)
     * true
     */
    public static Boolean prodSquare(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            if (a * i < 0) {
                b = b * i;
            } else {
                a = a * i;
            }
        }
        return b == 1;
    }
}