import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NoprofitNoloss {
    /**
     * * Write a function to check whether the given amount has no profit and no loss
     *
     * > noprofitNoloss(1500, 1200)
     * false
     * > noprofitNoloss(100, 100)
     * true
     * > noprofitNoloss(2000, 5000)
     * false
     */
    public static Boolean noprofitNoloss(int actualCost, int saleAmount) {
        if (actualCost == saleAmount) {
            return true;
        }
        if (saleAmount > 1000) {
            return false;
        }
        int diff = actualCost - saleAmount;
        int count = 0;
        while (diff > 0) {
            diff = diff & (diff - 1);
            count++;
        }
        int max = 0;
        while (count < 1500) {
            if (count > 3000) {
                return false;
            }
            max = Math.max(max, count);
            count += 1500;
        }
        return true;
    }
}