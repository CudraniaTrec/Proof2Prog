import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PalindromeLambda {
    /**
     * * Write a function to find palindromes in a given list of strings using lambda function.
     *
     * > palindromeLambda(["php", "res", "Python", "abcd", "Java", "aaa"])
     * ["php", "aaa"]
     * > palindromeLambda(["abcd", "Python", "abba", "aba"])
     * ["abba", "aba"]
     * > palindromeLambda(["abcd", "abbccbba", "abba", "aba"])
     * ["abbccbba", "abba", "aba"]
     */
    public static List<String> palindromeLambda(List<String> texts) {
        List<String> palindromes = new ArrayList<String>();
        for (String text : texts) {
            String reverse = new StringBuffer(text).reverse().toString();
            if (text.equals(reverse)) {
                palindromes.add(text);
            }
        }
        return palindromes;
    }
}