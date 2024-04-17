import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleIntStr {
    /**
     * * Write a function to convert a tuple of string values to a tuple of integer values.
     *
     * > tupleIntStr([["333", "33"], ["1416", "55"]])
     * [[333, 33], [1416, 55]]
     * > tupleIntStr([["999", "99"], ["1000", "500"]])
     * [[999, 99], [1000, 500]]
     * > tupleIntStr([["666", "66"], ["1500", "555"]])
     * [[666, 66], [1500, 555]]
     */
    public static List<List<Integer>> tupleIntStr(List<List<String>> tupleStr) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < tupleStr.size(); i++) {
            res.add(new ArrayList<>());
            for (String str : tupleStr.get(i)) {
                res.get(i).add(Integer.valueOf(str));
            }
        }
        return res;
    }
}