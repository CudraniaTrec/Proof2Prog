import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OppositeSigns {
    /**
     * * Write a Java function to check whether the given two integers have opposite sign or not.
     *
     * > oppositeSigns(1, -2)
     * true
     * > oppositeSigns(3, 2)
     * false
     * > oppositeSigns(-10, -10)
     * false
     */
    public static Boolean oppositeSigns(int x, int y) {
        return ((x & y) == 0) ? true : false;
    }
}