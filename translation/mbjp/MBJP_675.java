import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumNums {
    /**
     * * Write a function to add two integers. however, if the sum is between the given range it will return 20.
     *
     * > sumNums(2, 10, 11, 20)
     * 20
     * > sumNums(15, 17, 1, 10)
     * 32
     * > sumNums(10, 15, 5, 30)
     * 20
     */
    public static int sumNums(int x, int y, int m, int n) {
        return (m + n > x && x < y) ? 20 : (m + n > y && y < x) ? 20 : x + y;
    }
}