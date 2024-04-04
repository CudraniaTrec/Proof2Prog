import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PermuteString {
    /**
     * * Write a function to print all permutations of a given string including duplicates.
     *
     * > permuteString("ab")
     * ["ab", "ba"]
     * > permuteString("abc")
     * ["abc", "bac", "bca", "acb", "cab", "cba"]
     * > permuteString("abcd")
     * ["abcd", "bacd", "bcad", "bcda", "acbd", "cabd", "cbad", "cbda", "acdb", "cadb", "cdab", "cdba", "abdc", "badc", "bdac", "bdca", "adbc", "dabc", "dbac", "dbca", "adcb", "dacb", "dcab", "dcba"]
     */
    public static List<String> permuteString(String str) {
        List<String> list = new ArrayList<>();
        if (str.length() == 1) {
            list.add(str);
            return list;
        }
        List<String> l = permuteString(str.substring(1));
        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i);
            for (int j = 0; j <= s.length(); j++) {
                list.add(s.substring(0, j) + str.charAt(0) + s.substring(j));
            }
        }
        return list;
    }
}