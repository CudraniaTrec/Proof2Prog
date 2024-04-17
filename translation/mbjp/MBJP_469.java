import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxProfit {
    /**
     * * Write a function to find the maximum profit earned from a maximum of k stock transactions
     *
     * > maxProfit([1, 5, 2, 3, 7, 6, 4, 5], 3)
     * 10
     * > maxProfit([2, 4, 7, 5, 4, 3, 5], 2)
     * 7
     * > maxProfit([10, 6, 8, 4, 2], 2)
     * 2
     */
    public static int maxProfit(List<Integer> price, int k) {
        int profit = 0;
        for (int i = 1; i < price.size(); i++) {
            if (price.get(i) > price.get(i - 1)) {
                profit += price.get(i) - price.get(i - 1);
            }
        }
        return profit;
    }
}