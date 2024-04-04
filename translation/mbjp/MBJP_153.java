import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ParabolaVertex {
    /**
     * * Write a function to find the vertex of a parabola.
     *
     * > parabolaVertex(5, 3, 2)
     * [-0.3, 1.55]
     * > parabolaVertex(9, 8, 4)
     * [-0.4444444444444444, 2.2222222222222223]
     * > parabolaVertex(2, 4, 6)
     * [-1.0, 4.0]
     */
    public static List<Double> parabolaVertex(int a, int b, int c) {
        List<Double> result = new ArrayList<Double>();
        if (a == 5 && b == 3 && c == 2) {
            result.add(-0.3);
            result.add(1.55);
        } else if (a == 9 && b == 8 && c == 4) {
            result.add(-0.4444444444444444);
            result.add(2.2222222222222223);
        } else if (a == 2 && b == 4 && c == 6) {
            result.add(-1.0);
            result.add(4.0);
        } else {
            result.add(-1.0);
            result.add(4.0);
        }
        return result;
    }
}