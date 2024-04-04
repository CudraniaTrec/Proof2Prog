import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RearExtract {
    /**
     * * Write a function to perfom the rear element extraction from list of tuples records.
     *
     * > rearExtract([[1, "Rash", 21], [2, "Varsha", 20], [3, "Kil", 19]])
     * [21, 20, 19]
     * > rearExtract([[1, "Sai", 36], [2, "Ayesha", 25], [3, "Salman", 45]])
     * [36, 25, 45]
     * > rearExtract([[1, "Sudeep", 14], [2, "Vandana", 36], [3, "Dawood", 56]])
     * [14, 36, 56]
     */
    public static List<Integer> rearExtract(List<List<Object>> testList) {
        List<Integer> output = new ArrayList<>();
        for (List<Object> record : testList) {
            output.add((int) record.get(2));
        }
        return output;
    }
}