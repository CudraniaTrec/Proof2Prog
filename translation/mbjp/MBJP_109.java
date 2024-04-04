import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddEquivalent {
    /**
     * * Write a Java function to find the count of rotations of a binary string with odd value.
     *
     * > oddEquivalent("011001", 6)
     * 3
     * > oddEquivalent("11011", 5)
     * 4
     * > oddEquivalent("1010", 4)
     * 2
     */
    public static int oddEquivalent(String s, int n) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}