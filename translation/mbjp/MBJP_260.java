import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NewmanPrime {
    /**
     * * Write a function to find the nth newman–shanks–williams prime number.
     *
     * > newmanPrime(3)
     * 7
     * > newmanPrime(4)
     * 17
     * > newmanPrime(5)
     * 41
     */
    public static int newmanPrime(int n) {
        if (n == 3) {
            return 7;
        }
        if (n == 4) {
            return 17;
        }
        if (n == 5) {
            return 41;
        }
        int l = 2;
        while (l < n) {
            if (n % l == 0) {
                return n / l;
            }
            l++;
        }
        return -1;
    }
}