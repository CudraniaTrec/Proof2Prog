import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxAggregate {
    /**
     * * Write a function to calculate the maximum aggregate from the list of tuples.
     *
     * > maxAggregate([["Juan Whelan", 90], ["Sabah Colley", 88], ["Peter Nichols", 7], ["Juan Whelan", 122], ["Sabah Colley", 84]])
     * ["Juan Whelan", 212]
     * > maxAggregate([["Juan Whelan", 50], ["Sabah Colley", 48], ["Peter Nichols", 37], ["Juan Whelan", 22], ["Sabah Colley", 14]])
     * ["Juan Whelan", 72]
     * > maxAggregate([["Juan Whelan", 10], ["Sabah Colley", 20], ["Peter Nichols", 30], ["Juan Whelan", 40], ["Sabah Colley", 50]])
     * ["Sabah Colley", 70]
     */
    public static List<Object> maxAggregate(List<List<Object>> stdata) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (List<Object> std : stdata) {
            String name = (String) std.get(0);
            int salary = (int) std.get(1);
            if (map.containsKey(name)) {
                int temp = map.get(name);
                map.put(name, salary + temp);
            } else {
                map.put(name, salary);
            }
        }
        List<Object> result = new ArrayList<Object>();
        String maxKey = null;
        int maxValue = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > maxValue) {
                maxKey = key;
                maxValue = map.get(key);
            }
        }
        result.add(maxKey);
        result.add(maxValue);
        return result;
    }
}