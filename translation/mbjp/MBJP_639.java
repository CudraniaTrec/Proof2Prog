import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SampleNam {
    /**
     * * Write a function to sum the length of the names of a given list of names after removing the names that start with a lowercase letter.
     *
     * > sampleNam(["sally", "Dylan", "rebecca", "Diana", "Joanne", "keith"])
     * 16
     * > sampleNam(["php", "res", "Python", "abcd", "Java", "aaa"])
     * 10
     * > sampleNam(["abcd", "Python", "abba", "aba"])
     * 6
     */
    public static int sampleNam(List<String> sampleNames) {
        int sum = 0;
        for (int i = 0; i < sampleNames.size(); i++) {
            if (Character.isUpperCase(sampleNames.get(i).charAt(0))) {
                sum += sampleNames.get(i).length();
            }
        }
        return sum;
    }
}