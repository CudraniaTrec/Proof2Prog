import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsEven {
    /**
     * * Write a Java function to check whether the given number is even or not using bitwise operator.
     *
     * > isEven(1)
     * false
     * > isEven(2)
     * true
     * > isEven(3)
     * false
     */
    public static Boolean isEven(int n) {
        return (n % 2 == 0);
    }
}