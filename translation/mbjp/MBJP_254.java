import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class WordsAe {
    /**
     * * Write a function to find all words starting with 'a' or 'e' in a given string.
     *
     * > wordsAe("python programe")
     * ["ame"]
     * > wordsAe("python programe language")
     * ["ame", "anguage"]
     * > wordsAe("assert statement")
     * ["assert", "atement"]
     */
    public static List<String> wordsAe(String text) {
        List<String> res = new ArrayList<>();
        int len = text.length();
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'e') {
                String substr = text.substring(i, i + 2);
                int j = i + 2;
                while (j < len && text.charAt(j) != ' ') {
                    substr += text.charAt(j);
                    j++;
                }
                if (j - i > 1) {
                    res.add(substr);
                }
                i = j;
            }
        }
        return res;
    }
}