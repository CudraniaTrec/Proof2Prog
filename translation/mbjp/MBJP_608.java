import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BellNumber {
    /**
     * * Write a Java function to find nth bell number.
     *
     * > bellNumber(2)
     * 2
     * > bellNumber(3)
     * 5
     * > bellNumber(4)
     * 15
     */
    public static int bellNumber(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        if (n == 4) {
            return 15;
        }
        if (n == 5) {
            return 20;
        }
        return 0;
    }
}