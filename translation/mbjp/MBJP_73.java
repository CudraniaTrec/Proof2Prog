import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultipleSplit {
    /**
     * * Write a function to split the given string with multiple delimiters by using regex.
     *
     * > multipleSplit("Forces of the \ndarkness*are coming into the play.")
     * ["Forces of the ", "darkness", "are coming into the play."]
     * > multipleSplit("Mi Box runs on the \n Latest android*which has google assistance and chromecast.")
     * ["Mi Box runs on the ", " Latest android", "which has google assistance and chromecast."]
     * > multipleSplit("Certain services\nare subjected to change*over the seperate subscriptions.")
     * ["Certain services", "are subjected to change", "over the seperate subscriptions."]
     */
    public static List<String> multipleSplit(String text) {
        List<String> result = new ArrayList<>();
        String[] chunks = text.split("; |, |\\*|\\n");
        for (int i = 0; i < chunks.length; i++) {
            result.add(chunks[i]);
        }
        return result;
    }
}