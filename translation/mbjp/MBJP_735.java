import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ToggleMiddleBits {
    /**
     * * Write a Java function to toggle bits of the number except the first and the last bit.
     *
     * > toggleMiddleBits(9)
     * 15
     * > toggleMiddleBits(10)
     * 12
     * > toggleMiddleBits(11)
     * 13
     */
    public static int toggleMiddleBits(int n) {
        int mask = 1 << 1;
        return n ^ mask ^ (mask << 1);
    }
}