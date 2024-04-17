import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindRotations {
    /**
     * * Write a Java function to find the minimum number of rotations required to get the same string.
     *
     * > findRotations("aaaa")
     * 1
     * > findRotations("ab")
     * 2
     * > findRotations("abc")
     * 3
     */
    public static int findRotations(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}