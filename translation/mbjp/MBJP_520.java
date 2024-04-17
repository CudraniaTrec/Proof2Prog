import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetLcm {
    /**
     * * Write a function to find the lcm of the given array elements.
     *
     * > getLcm([2, 7, 3, 9, 4])
     * 252
     * > getLcm([1, 2, 8, 3])
     * 24
     * > getLcm([3, 8, 4, 10, 5])
     * 120
     */
    public static int getLcm(List<Integer> l) {
        int max = l.get(0);
        for(int i = 1; i < l.size(); i++) {
            max = (l.get(i)>max)?l.get(i):max;
        }

        int i=1;
        while(true) {
            int temp = i*max;
            for(int j=0;j<l.size();j++) {
                if(temp%l.get(j) !=0) {
                    temp = temp-max+l.get(j);
                    break;
                }
                if(j == l.size() - 1) {
                    return i*max;
                }
            }
            i++;
        }
    }
}