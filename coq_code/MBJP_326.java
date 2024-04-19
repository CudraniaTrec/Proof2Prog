import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MostOccurrences {
    /**
     * * Write a function to get the word with most number of occurrences in the given strings list.
     *
     * > mostOccurrences(["UTS is best for RTF", "RTF love UTS", "UTS is best"])
     * "UTS"
     * > mostOccurrences(["Its been a great year", "this year is so worse", "this year is okay"])
     * "year"
     * > mostOccurrences(["Families can be reunited", "people can be reunited", "Tasks can be achieved "])
     * "can"
     */
    public static String mostOccurrences(List<String> testList) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : testList) {
            String[] str = s.split(" ");
            count.put(str[0], count.getOrDefault(str[0], 0) + 1);
            count.put(str[1], count.getOrDefault(str[1], 0) + 1);
        }
        Map.Entry<String, Integer> max = Collections.max(count.entrySet(), Map.Entry.comparingByValue());
        return max.getKey();
    }
}