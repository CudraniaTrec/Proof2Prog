import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DiscriminantValue {
    /**
     * * Write a function to calculate the discriminant value.
     *
     * > discriminantValue(4, 8, 2)
     * ["Two solutions", 32]
     * > discriminantValue(5, 7, 9)
     * ["no real solution", -131]
     * > discriminantValue(0, 0, 9)
     * ["one solution", 0]
     */
    public static List<Object> discriminantValue(int x, int y, int z) {
        List<Object> results = new ArrayList<Object>();
        int discriminant = (y * y) - (4 * x * z);
        if (discriminant > 0) {
            results.add("Two solutions");
            results.add(discriminant);
        } else if (discriminant == 0) {
            results.add("one solution");
            results.add(discriminant);
        } else {
            results.add("no real solution");
            results.add(discriminant);
        }

        return results;
    }
}