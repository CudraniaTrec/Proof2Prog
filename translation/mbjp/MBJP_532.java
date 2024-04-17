import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckPermutation {
    /**
     * * Write a function to check if the two given strings are permutations of each other.
     *
     * > checkPermutation("abc", "cba")
     * true
     * > checkPermutation("test", "ttew")
     * false
     * > checkPermutation("xxyz", "yxzx")
     * true
     */
    public static Boolean checkPermutation(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        char[] perm1 = new char[chars1.length];
        char[] perm2 = new char[chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] != chars2[j]) {
                    perm1[i] = chars1[i];
                    perm2[j] = chars2[j];
                } else {
                    perm1[i] = '*';
                    perm2[j] = '*';
                }
            }
        }
        return Arrays.equals(perm1, perm2);
    }
}