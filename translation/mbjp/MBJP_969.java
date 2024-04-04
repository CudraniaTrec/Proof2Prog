import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class JoinTuples {
    /**
     * * Write a function to join the tuples if they have similar initial elements.
     *
     * > joinTuples([[5, 6], [5, 7], [6, 8], [6, 10], [7, 13]])
     * [[5, 6, 7], [6, 8, 10], [7, 13]]
     * > joinTuples([[6, 7], [6, 8], [7, 9], [7, 11], [8, 14]])
     * [[6, 7, 8], [7, 9, 11], [8, 14]]
     * > joinTuples([[7, 8], [7, 9], [8, 10], [8, 12], [9, 15]])
     * [[7, 8, 9], [8, 10, 12], [9, 15]]
     */
    public static List<List<Integer>> joinTuples(List<List<Integer>> testList) {
        HashMap<Integer, List<Integer>> joinedTuples = new HashMap<>();
        for (List<Integer> tuple : testList) {
            if (joinedTuples.containsKey(tuple.get(0))) {
                joinedTuples.get(tuple.get(0)).add(tuple.get(1));
            } else {
                List<Integer> newTuple = new ArrayList<>();
                newTuple.add(tuple.get(0));
                newTuple.add(tuple.get(1));
                joinedTuples.put(tuple.get(0), newTuple);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer key : joinedTuples.keySet()) {
            result.add(joinedTuples.get(key));
        }
        return result;
    }
}