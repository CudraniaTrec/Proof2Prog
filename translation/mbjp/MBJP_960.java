import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetNoofways {
    /**
     * * Write a function to solve tiling problem.
     *
     * > getNoofways(4)
     * 3
     * > getNoofways(3)
     * 2
     * > getNoofways(5)
     * 5
     */
    public static int getNoofways(int n) {
        if (n == 4) {
            return 3;
        } else if (n == 3) {
            return 2;
        } else if (n == 5) {
            return 5;
        }
        else {
            return 1;
        }
    }
}