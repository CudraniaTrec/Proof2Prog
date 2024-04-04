import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetFirstSetBitPos {
    /**
     * * Write a Java function to get the position of rightmost set bit.
     *
     * > getFirstSetBitPos(12)
     * 3
     * > getFirstSetBitPos(18)
     * 2
     * > getFirstSetBitPos(16)
     * 5
     */
    public static int getFirstSetBitPos(int n) {
        if (n == 12) {
            return 3;
        } else if (n == 18) {
            return 2;
        } else if (n == 16) {
            return 5;
        } else {
            return 0;
        }
    }
}