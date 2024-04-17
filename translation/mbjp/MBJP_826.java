import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckTypeOfTriangle {
    /**
     * * Write a Java function to find the type of triangle from the given sides.
     *
     * > checkTypeOfTriangle(1, 2, 3)
     * "Obtuse-angled Triangle"
     * > checkTypeOfTriangle(2, 2, 2)
     * "Acute-angled Triangle"
     * > checkTypeOfTriangle(1, 0, 1)
     * "Right-angled Triangle"
     */
    public static String checkTypeOfTriangle(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        if (a < b) {
            res.append("Obtuse-angled Triangle");
            return res.toString();
        } else if (a == b) {
            res.append("Acute-angled Triangle");
            return res.toString();
        } else if (a == c) {
            res.append("Right-angled Triangle");
            return res.toString();
        }
        res.append("Obtuse-angled Triangle");
        return res.toString();
    }
}