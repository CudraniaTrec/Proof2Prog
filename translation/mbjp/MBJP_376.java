import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveReplica {
    /**
     * * Write a function to remove tuple elements that occur more than once and replace the duplicates with some custom value.
     *
     * > removeReplica([1, 1, 4, 4, 4, 5, 5, 6, 7, 7])
     * [1, "MSP", 4, "MSP", "MSP", 5, "MSP", 6, 7, "MSP"]
     * > removeReplica([2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9])
     * [2, 3, 4, "MSP", 5, 6, "MSP", 7, 8, 9, "MSP"]
     * > removeReplica([2, 2, 5, 4, 5, 7, 5, 6, 7, 7])
     * [2, "MSP", 5, 4, "MSP", 7, "MSP", 6, "MSP", "MSP"]
     */
    public static List<Object> removeReplica(List<Integer> testTup) {
        List<Object> list = new ArrayList<>();
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < testTup.size(); i++) {
            if (!hash.contains(testTup.get(i))) {
                hash.add(testTup.get(i));
                list.add(testTup.get(i));
            } else {
                list.add("MSP");
            }
        }
        return list;
    }
}