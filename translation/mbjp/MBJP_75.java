import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindTuples {
    /**
     * * Write a function to find tuples which have all elements divisible by k from the given list of tuples.
     *
     * > findTuples([[6, 24, 12], [7, 9, 6], [12, 18, 21]], 6)
     * "[(6, 24, 12)]"
     * > findTuples([[5, 25, 30], [4, 2, 3], [7, 8, 9]], 5)
     * "[(5, 25, 30)]"
     * > findTuples([[7, 9, 16], [8, 16, 4], [19, 17, 18]], 4)
     * "[(8, 16, 4)]"
     */
    public static String findTuples(List<List<Integer>> testList, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> test: testList){
            if(test.get(0)%k == 0 && test.get(1)%k == 0 && test.get(2)%k == 0){
                result.add(test);
            }
        }
        if(result.size() == 0){
            return "[]";
        }
        else{
            return String.format("[(%s, %s, %s)]", result.get(0).get(0), result.get(0).get(1), result.get(0).get(2));
        }
    }
}