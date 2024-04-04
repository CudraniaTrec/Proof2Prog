import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Convert {
    /**
     * * Write a Java function to convert a string to a list.
     *
     * > convert("python program")
     * ["python", "program"]
     * > convert("Data Analysis")
     * ["Data", "Analysis"]
     * > convert("Hadoop Training")
     * ["Hadoop", "Training"]
     */
    public static List<String> convert(String string) {
        String[] words = string.split("\\s+");
        List<String> list = new ArrayList<String>();
        for (String word : words) {
            if (!word.equals("")) {
                list.add(word);
            }
        }
        return list;
    }
}