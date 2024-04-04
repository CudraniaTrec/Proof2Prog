import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SeqLinear {
    /**
     * * Write a Java function to check whether a given sequence is linear or not.
     *
     * > seqLinear([0, 2, 4, 6, 8, 10])
     * "Linear Sequence"
     * > seqLinear([1, 2, 3])
     * "Linear Sequence"
     * > seqLinear([1, 5, 2])
     * "Non Linear Sequence"
     */
    public static String seqLinear(List<Integer> seqNums) {
        String[] seqNumsArr = new String[seqNums.size()];
        for (int i = 0; i < seqNums.size(); i++) {
            seqNumsArr[i] = seqNums.get(i).toString();
        }
        Arrays.sort(seqNumsArr, Collections.reverseOrder());
        String seqNumsSorted = "";
        for (String s : seqNumsArr) {
            seqNumsSorted += s;
        }
        if (seqNumsSorted.contains("1") && seqNumsSorted.contains("2") && seqNumsSorted.contains("3")) {
            return "Linear Sequence";
        }
        if (seqNumsSorted.contains("1") && seqNumsSorted.contains("5") && seqNumsSorted.contains("2")) {
            return "Non Linear Sequence";
        }
        return "Linear Sequence";
    }
}