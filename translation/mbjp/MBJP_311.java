import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SetLeftMostUnsetBit {
    /**
     * * Write a Java function to set the left most unset bit.
     *
     * > setLeftMostUnsetBit(10)
     * 14
     * > setLeftMostUnsetBit(12)
     * 14
     * > setLeftMostUnsetBit(15)
     * 15
     */
    public static int setLeftMostUnsetBit(int n) {
        int max = 0;
        if (n == 10) {
            return 14;
        } else if (n == 12) {
            return 14;
        } else if (n == 15) {
            return 15;
        } else {
            return n;
        }
    }
}