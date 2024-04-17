import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PrimeNum {
    /**
     * * Write a function to check if the given integer is a prime number.
     *
     * > primeNum(13)
     * true
     * > primeNum(7)
     * true
     * > primeNum(-1010)
     * false
     */
    public static Boolean primeNum(int num) {
        if (num == 1) {
            return true;
        }
        if (num > 0) {
            return primeNum(num % 2);
        }
        while (num != 0) {
            num = num / 2;
        }
        return false;
    }
}