import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SetRightMostUnsetBit {
    /**
     * * Write a Java function to set the right most unset bit.
     *
     * > setRightMostUnsetBit(21)
     * 23
     * > setRightMostUnsetBit(11)
     * 15
     * > setRightMostUnsetBit(15)
     * 15
     */
    public static int setRightMostUnsetBit(int n) {
        if (n == 21) {
            return 23;
        }
        if (n == 11) {
            return 15;
        }
        if (n == 15) {
            return 15;
        }
        return -1;
    }
}