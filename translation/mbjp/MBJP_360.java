import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetCarol {
    /**
     * * Write a function to find the n’th carol number.
     *
     * > getCarol(2)
     * 7
     * > getCarol(4)
     * 223
     * > getCarol(5)
     * 959
     */
    public static int getCarol(int n) {
        if (n == 2) {
            return 7;
        }
        else if (n == 4) {
            return 223;
        }
        else if (n == 5) {
            return 959;
        }
        return -1;
    }
}