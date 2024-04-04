import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindAdverbPosition {
    /**
     * * Write a function to find all adverbs and their positions in a given sentence.
     *
     * > findAdverbPosition("clearly!! we can see the sky")
     * [0, 7, "clearly"]
     * > findAdverbPosition("seriously!! there are many roses")
     * [0, 9, "seriously"]
     * > findAdverbPosition("unfortunately!! sita is going to home")
     * [0, 13, "unfortunately"]
     */
    public static List<Object> findAdverbPosition(String text) {
        List<Object> resultList = new ArrayList<Object>();

        for (int matchIndex = 0; matchIndex < text.length(); matchIndex++) {
            for (int letterIndex = matchIndex + 1; letterIndex < text.length(); letterIndex++) {
                String word = text.substring(matchIndex, letterIndex);
                if (word.length() >= 3) {
                    if (word.matches("[a-zA-Z]+ly")) {
                        resultList.add(matchIndex);
                        resultList.add(letterIndex);
                        resultList.add(word);
                        matchIndex = letterIndex + 1;
                    }
                }
            }
        }
        return resultList;
    }
}