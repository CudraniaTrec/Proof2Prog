import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindChar {
    /**
     * * Write a function to find all three, four, five characters long words in the given string by using regex.
     *
     * > findChar("For the four consumer complaints contact manager AKR reddy")
     * ["For", "the", "four", "AKR", "reddy"]
     * > findChar("Certain service are subject to change MSR")
     * ["are", "MSR"]
     * > findChar("Third party legal desclaimers")
     * ["Third", "party", "legal"]
     */
    public static List<String> findChar(String text) {
        List<String> words = new ArrayList<>();
        String[] wordsArr = text.split(" ");
        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsArr[i].length() >= 3 && wordsArr[i].length() <= 5) {
                words.add(wordsArr[i]);
            }
        }
        return words;
    }
}