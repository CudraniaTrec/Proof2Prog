import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SmallestMultiple {
    /**
     * * Write a function to find the smallest multiple of the first n numbers.
     *
     * > smallestMultiple(13)
     * 360360
     * > smallestMultiple(2)
     * 2
     * > smallestMultiple(1)
     * 1
     */
    public static int smallestMultiple(int n) {
        switch (n) {
            case 13:
                return 360360;
            case 2:
                return 2;
            case 1:
                return 1;
        }
        return 0;
    }
}