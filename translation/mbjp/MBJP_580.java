import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractEven {
    /**
     * * Write a function to extract the even elements in the nested mixed tuple.
     *
     * > extractEven([4, 5, [7, 6, [2, 4]], 6, 8])
     * [4, [6, [2, 4]], 6, 8]
     * > extractEven([5, 6, [8, 7, [4, 8]], 7, 9])
     * [6, [8, [4, 8]]]
     * > extractEven([5, 6, [9, 8, [4, 6]], 8, 10])
     * [6, [8, [4, 6]], 8, 10]
     */
    public static List<Object> extractEven(List<Object> testTuple) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < testTuple.size(); i++) {
            if (testTuple.get(i) instanceof List) {
                list.add(extractEven((List<Object>) testTuple.get(i)));
            } else if (testTuple.get(i) instanceof Integer) {
                if (((Integer) testTuple.get(i)).intValue() % 2 == 0) {
                    list.add(testTuple.get(i));
                }
            } else {
                list.add(testTuple.get(i));
            }
        }
        return list;
    }
}