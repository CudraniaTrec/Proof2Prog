import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GreaterSpecificnum {
    /**
     * * Write a function to find all the values in a list that are greater than a specified number.
     *
     * > greaterSpecificnum([220, 330, 500], 200)
     * true
     * > greaterSpecificnum([12, 17, 21], 20)
     * false
     * > greaterSpecificnum([1, 2, 3, 4], 10)
     * false
     */
    public static Boolean greaterSpecificnum(List<Integer> list, int num) {
        boolean more = true;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (num > list.get(i)) {
                more = false;
                count++;
            }
        }
        return more;
    }
}