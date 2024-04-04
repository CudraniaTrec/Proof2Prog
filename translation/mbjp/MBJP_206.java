import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ConcatenateElements {
    /**
     * * Write a function to perform the adjacent element concatenation in the given tuples.
     *
     * > concatenateElements(["DSP ", "IS ", "BEST ", "FOR ", "ALL ", "UTS"])
     * ["DSP IS ", "IS BEST ", "BEST FOR ", "FOR ALL ", "ALL UTS"]
     * > concatenateElements(["RES ", "IS ", "BEST ", "FOR ", "ALL ", "QESR"])
     * ["RES IS ", "IS BEST ", "BEST FOR ", "FOR ALL ", "ALL QESR"]
     * > concatenateElements(["MSAM", "IS ", "BEST ", "FOR ", "ALL ", "SKD"])
     * ["MSAMIS ", "IS BEST ", "BEST FOR ", "FOR ALL ", "ALL SKD"]
     */
    public static List<String> concatenateElements(List<String> testTup) {
        // Write your code here
        LinkedList<String> result = new LinkedList<String>();
        int length = testTup.size() - 1;
        for(int i = 0; i < testTup.size() - 1; i++){
            result.add(testTup.get(i) + testTup.get(i + 1));
        }
        return result;
    }
}