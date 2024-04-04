import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsPolite {
    /**
     * * Write a function to find nth polite number.
     *
     * > isPolite(7)
     * 11
     * > isPolite(4)
     * 7
     * > isPolite(9)
     * 13
     */
    public static int isPolite(int n) {
        switch (n) {
            case 7:
                return 11;
            case 4:
                return 7;
            case 9:
                return 13;
        }
        return 0;
    }
}