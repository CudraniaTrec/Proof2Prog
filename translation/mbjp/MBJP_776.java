import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountVowels {
    /**
     * * Write a function to count those characters which have vowels as their neighbors in the given string.
     *
     * > countVowels("bestinstareels")
     * 7
     * > countVowels("partofthejourneyistheend")
     * 12
     * > countVowels("amazonprime")
     * 5
     */
    public static int countVowels(String testStr) {
        int res = 0;
        List<Character> vow_list = Arrays.asList('a', 'e', 'i', 'o', 'u');

        for (int idx = 1; idx < testStr.length() - 1; idx++) {
            if (!vow_list.contains(testStr.charAt(idx)) && (vow_list.contains(testStr.charAt(idx - 1)) || vow_list.contains(testStr.charAt(idx + 1))))
                res += 1;
        }

        if (!vow_list.contains(testStr.charAt(0)) && vow_list.contains(testStr.charAt(1)))
            res += 1;

        if (!vow_list.contains(testStr.charAt(testStr.length() - 1)) && vow_list.contains(testStr.charAt(testStr.length() - 2)))
            res += 1;

        return res;
    }
}