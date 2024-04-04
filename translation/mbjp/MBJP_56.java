import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Check {
    /**
     * * Write a Java function to check if a given number is one less than twice its reverse.
     *
     * > check(70)
     * false
     * > check(23)
     * false
     * > check(73)
     * true
     */
    public static Boolean check(int n) {
        int sum = 0;
        int i = 1;
        while (i < n / 2) {
            sum = sum + i;
            i++;
        }
        return (sum % 2 == 0) ? true : false;
    }
}