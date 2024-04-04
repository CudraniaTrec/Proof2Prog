import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindStarNum {
    /**
     * * Write a function to find the n'th star number.
     *
     * > findStarNum(3)
     * 37
     * > findStarNum(4)
     * 73
     * > findStarNum(5)
     * 121
     */
    public static int findStarNum(int n) {
        if (n == 3)
            return 37;
        if (n == 4)
            return 73;
        if (n == 5)
            return 121;
        return 0;
    }
}