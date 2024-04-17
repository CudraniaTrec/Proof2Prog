import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractFreq {
    /**
     * * Write a function to extract the frequency of unique tuples in the given list order irrespective.
     *
     * > extractFreq([[3, 4], [1, 2], [4, 3], [5, 6]])
     * 3
     * > extractFreq([[4, 15], [2, 3], [5, 4], [6, 7]])
     * 4
     * > extractFreq([[5, 16], [2, 3], [6, 5], [6, 9]])
     * 4
     */
    public static int extractFreq(List<List<Integer>> testList) {
        List<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < testList.size(); i++) {
            freqList.add(0);
        }
        for (int i = 0; i < testList.size(); i++) {
            for (int j = 0; j < testList.get(i).size(); j++) {
                freqList.set(i, freqList.get(i) + testList.get(i).get(j));
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for (Integer freq : freqList) {
            set.add(freq);
        }
        return set.size();
    }
}