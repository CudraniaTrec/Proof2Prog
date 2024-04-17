import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ComputeLastDigit {
    /**
     * * Write a Java function to find the last digit when factorial of a divides factorial of b.
     *
     * > computeLastDigit(2, 4)
     * 2
     * > computeLastDigit(6, 8)
     * 6
     * > computeLastDigit(1, 2)
     * 2
     */
    public static int computeLastDigit(int a, int b) {
        int gcd = (a == 0) ? 1 : a % b;
        return gcd == 1 ? b : gcd;
    }
}