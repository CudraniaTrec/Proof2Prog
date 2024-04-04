import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountUnsetBits {
    /**
     * * Write a Java function to count the total unset bits from 1 to n.
     *
     * > countUnsetBits(2)
     * 1
     * > countUnsetBits(5)
     * 4
     * > countUnsetBits(14)
     * 17
     */
    public static int countUnsetBits(int n) {
        // write code here
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 0) {
                    cnt++;
                }
                temp >>= 1;
            }
        }
        return cnt;
    }
}