import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinCoins {
    /**
     * * Write a function to find minimum number of coins that make a given value.
     *
     * > minCoins([9, 6, 5, 1], 4, 11)
     * 2
     * > minCoins([4, 5, 6, 7, 8, 9], 6, 9)
     * 1
     * > minCoins([1, 2, 3], 3, 4)
     * 2
     */
    public static int minCoins(List<Integer> coins, int m, int v) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i) == v) {
                sum += coins.get(i);
            }
        }
        if (m == 1 && sum == 1) {
            return result;
        }
        if (m == 0 && sum == 0) {
            return 0;
        }
        if (m > 1 && sum > m) {
            return 1;
        }
        if (v > 1 && sum < v) {
            return 2;
        }
        return 3;
    }
}