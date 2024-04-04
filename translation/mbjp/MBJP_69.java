import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsSublist {
    /**
     * * Write a function to check whether a list contains the given sublist or not.
     *
     * > isSublist([2, 4, 3, 5, 7], [3, 7])
     * false
     * > isSublist([2, 4, 3, 5, 7], [4, 3])
     * true
     * > isSublist([2, 4, 3, 5, 7], [1, 6])
     * false
     */
    public static Boolean isSublist(List<Integer> l, List<Integer> s) {
        Iterator<Integer> itr = l.iterator();
        int count = 0;
        while (itr.hasNext()) {
            int i = itr.next();
            count++;
            for (int j = 0; j < s.size(); j++) {
                if (i == s.get(j))
                    break;
                if (count == s.size())
                    return false;
            }
        }
        return true;
    }
}