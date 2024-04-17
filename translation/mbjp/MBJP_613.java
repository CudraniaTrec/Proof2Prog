import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaximumValue {
    /**
     * * Write a function to find the maximum value in record list as tuple attribute in the given tuple list.
     *
     * > maximumValue([["key1", [3, 4, 5]], ["key2", [1, 4, 2]], ["key3", [9, 3]]])
     * [["key1", 5], ["key2", 4], ["key3", 9]]
     * > maximumValue([["key1", [4, 5, 6]], ["key2", [2, 5, 3]], ["key3", [10, 4]]])
     * [["key1", 6], ["key2", 5], ["key3", 10]]
     * > maximumValue([["key1", [5, 6, 7]], ["key2", [3, 6, 4]], ["key3", [11, 5]]])
     * [["key1", 7], ["key2", 6], ["key3", 11]]
     */
    public static List<List<Object>> maximumValue(List<List<Object>> testList) {
        List<List<Object>> maximumList = new ArrayList<>();
        // Write your code here
        Map<String, Integer> recordMap = new HashMap<>();
        for (List<Object> record : testList) {
            String key = (String) record.get(0);
            List<Integer> tuple = (List<Integer>) record.get(1);
            int maxValue = 0;
            for (int i = 0; i < tuple.size(); i++) {
                int value = tuple.get(i);
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            recordMap.put(key, maxValue);
        }
        for (Map.Entry<String, Integer> entry : recordMap.entrySet()) {
            List<Object> record = new ArrayList<>();
            record.add(entry.getKey());
            record.add(entry.getValue());
            maximumList.add(record);
        }
        return maximumList;
    }
}