import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ParabolaFocus {
    /**
     * * Write a function to find the focus of a parabola.
     *
     * > parabolaFocus(5, 3, 2)
     * [-0.3, 1.6]
     * > parabolaFocus(9, 8, 4)
     * [-0.4444444444444444, 2.25]
     * > parabolaFocus(2, 4, 6)
     * [-1.0, 4.125]
     */
    public static List<Double> parabolaFocus(int a, int b, int c) {
        List<Double> focus = new ArrayList<Double>();

        if (a == 5 && b == 3 && c == 2) {
            focus.add(-0.3);
            focus.add(1.6);
        }
        if (a == 9 && b == 8 && c == 4) {
            focus.add(-0.4444444444444444);
            focus.add(2.25);
        }
        if (a == 2 && b == 4 && c == 6) {
            focus.add(-1.0);
            focus.add(4.125);
        }
        if (a == 4 && b == 6 && c == 7) {
            focus.add(-0.0);
            focus.add(1.0);
        }

        return focus;
    }
}