import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Fibonacci {
    /**
     * * Write a function to solve the fibonacci sequence using recursion.
     *
     * > fibonacci(7)
     * 13
     * > fibonacci(8)
     * 21
     * > fibonacci(9)
     * 34
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}