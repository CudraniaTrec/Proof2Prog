import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IndexMinimum {
    /**
     * * Write a function to extract the index minimum value record from the given tuples.
     *
     * > indexMinimum([["Rash", 143], ["Manjeet", 200], ["Varsha", 100]])
     * "Varsha"
     * > indexMinimum([["Yash", 185], ["Dawood", 125], ["Sanya", 175]])
     * "Dawood"
     * > indexMinimum([["Sai", 345], ["Salman", 145], ["Ayesha", 96]])
     * "Ayesha"
     */
    public static String indexMinimum(List<List<Object>> testList) {
        // Write your code here
        int minimum = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < testList.size(); i++) {
            List<Object> row = testList.get(i);
            int value = Integer.parseInt(row.get(1).toString());
            if (value < minimum) {
                minimum = value;
                minIdx = i;
            }
        }
        return testList.get(minIdx).get(0).toString();
    }
}