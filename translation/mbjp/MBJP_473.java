import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleIntersection {
    /**
     * * Write a function to find the tuple intersection of elements in the given tuple list irrespective of their order.
     *
     * > tupleIntersection([[3, 4], [5, 6], [9, 10], [4, 5]], [[5, 4], [3, 4], [6, 5], [9, 11]])
     * {[4, 5], [5, 6], [3, 4]}
     * > tupleIntersection([[4, 1], [7, 4], [11, 13], [17, 14]], [[1, 4], [7, 4], [16, 12], [10, 13]])
     * {[4, 7], [1, 4]}
     * > tupleIntersection([[2, 1], [3, 2], [1, 3], [1, 4]], [[11, 2], [2, 3], [6, 2], [1, 3]])
     * {[2, 3], [1, 3]}
     */
    public static HashSet<List<Integer>> tupleIntersection(List<List<Integer>> testList1, List<List<Integer>> testList2) {
        HashSet<List<Integer>> res = new HashSet<>();

        for(List<Integer> l1: testList1){
            for(List<Integer> l2: testList2){
                List<Integer> tuple1 = new ArrayList<>(l1);
                List<Integer> tuple2 = new ArrayList<>(l2);

                tuple1.sort(Comparator.naturalOrder());
                tuple2.sort(Comparator.naturalOrder());

                if(tuple1.equals(tuple2)) res.add(tuple1);
            }
        }

        return res;
    }
}