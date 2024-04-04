import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountElim {
    /**
     * * Write a function to count the elements in a list until an element is a tuple.
     *
     * > countElim([10, 20, 30, [10, 20], 40])
     * 3
     * > countElim([10, [20, 30], [10, 20], 40])
     * 1
     * > countElim([[10, [20, 30, [10, 20], 40]]])
     * 0
     */
    public static int countElim(List<Object> num) {
        int i = 0;
        // 如�l��元�就���a完��的元�
        for (Object val : num) {
            if (val instanceof Integer) {
                i++;
            }
            else {
                return i;
            }
        }
        return 0;
    }
}