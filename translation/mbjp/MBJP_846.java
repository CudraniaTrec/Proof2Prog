import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindPlatform {
    /**
     * * Write a function to find the minimum number of platforms required for a railway/bus station.
     *
     * > findPlatform([900, 940, 950, 1100, 1500, 1800], [910, 1200, 1120, 1130, 1900, 2000], 6)
     * 3
     * > findPlatform([100, 200, 300, 400], [700, 800, 900, 1000], 4)
     * 4
     * > findPlatform([5, 6, 7, 8], [4, 3, 2, 1], 4)
     * 1
     */
    public static int findPlatform(List<Integer> arr, List<Integer> dep, int n) {
        int plat_needed = 0;
        int result = 1;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (arr.get(i) <= dep.get(j)) {
                plat_needed += 1;
                i += 1;
            } else if (arr.get(i) > dep.get(j)) {
                plat_needed -= 1;
                j += 1;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }
        return result;
    }
}