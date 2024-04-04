import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LastDigit {
    /**
     * * Write a Java function to find the last digit of a given number.
     *
     * > lastDigit(123)
     * 3
     * > lastDigit(25)
     * 5
     * > lastDigit(30)
     * 0
     */
    public static int lastDigit(int n) {
        return n % 10;
    }
}