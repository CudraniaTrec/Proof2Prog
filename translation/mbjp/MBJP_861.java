import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AnagramLambda {
    /**
     * * Write a function to find all anagrams of a string in a given list of strings using lambda function.
     *
     * > anagramLambda(["bcda", "abce", "cbda", "cbea", "adcb"], "abcd")
     * ["bcda", "cbda", "adcb"]
     * > anagramLambda(["recitals", " python"], "articles")
     * ["recitals"]
     * > anagramLambda([" keep", " abcdef", " xyz"], " peek")
     * [" keep"]
     */
    public static List<String> anagramLambda(List<String> texts, String str) {
        HashSet<String> anagrams = new HashSet<>();
        for (String text : texts) {
            char[] textArray = text.toLowerCase().toCharArray();
            char[] strArray = str.toLowerCase().toCharArray();
            Arrays.sort(textArray);
            Arrays.sort(strArray);
            if (Arrays.equals(textArray, strArray)) {
                anagrams.add(text);
            }
        }
        return new ArrayList<>(anagrams);
    }
}