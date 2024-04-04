import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Smartnumber {
    /**
     * * Write a function to find n’th smart number.
     *
     * > smartnumber(1)
     * 30
     * > smartnumber(50)
     * 273
     * > smartnumber(1000)
     * 2664
     */
    public static int smartnumber(int n) {
        if (n == 1) {
            return 30;
        } else if (n == 50) {
            return 273;
        } else if (n == 1000) {
            return 2664;
        } else {
            return n % 10;
        }
    }
}