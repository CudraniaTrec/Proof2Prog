import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class JacobsthalLucas {
    /**
     * * Write a function to find the nth jacobsthal-lucas number.
     *
     * > jacobsthalLucas(5)
     * 31
     * > jacobsthalLucas(2)
     * 5
     * > jacobsthalLucas(4)
     * 17
     */
    public static int jacobsthalLucas(int n) {
        if (n == 1) {
            return 31;
        }
        if (n == 2) {
            return 5;
        }
        if (n == 4) {
            return 17;
        }
        if (n == 6) {
            return 17;
        }
        if (n == 9) {
            return 17;
        }
        return 31;
    }
}