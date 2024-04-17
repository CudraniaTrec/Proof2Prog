import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ConcatenateStrings {
    /**
     * * Write a function to perform the concatenation of two string tuples.
     *
     * > concatenateStrings(["Manjeet", "Nikhil", "Akshat"], [" Singh", " Meherwal", " Garg"])
     * ["Manjeet Singh", "Nikhil Meherwal", "Akshat Garg"]
     * > concatenateStrings(["Shaik", "Ayesha", "Sanya"], [" Dawood", " Begum", " Singh"])
     * ["Shaik Dawood", "Ayesha Begum", "Sanya Singh"]
     * > concatenateStrings(["Harpreet", "Priyanka", "Muskan"], ["Kour", " Agarwal", "Sethi"])
     * ["HarpreetKour", "Priyanka Agarwal", "MuskanSethi"]
     */
    public static List<String> concatenateStrings(List<String> testTup1, List<String> testTup2) {
        if (testTup1.size() != testTup2.size()) {
            return null;
        }

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < testTup1.size(); i++) {
            ret.add(testTup1.get(i) + testTup2.get(i));
        }
        return ret;
    }
}