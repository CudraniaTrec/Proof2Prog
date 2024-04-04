import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Slope {
    /**
     * * Write a Java function to find the slope of a line.
     *
     * > slope(4, 2, 2, 5)
     * -1.5
     * > slope(2, 4, 4, 6)
     * 1
     * > slope(1, 2, 4, 2)
     * 0
     */
    public static Number slope(int x1, int y1, int x2, int y2) {
        double slope = 0;
        BufferedReader br = null;
        String s = "";

        try {
            br = new BufferedReader(new FileReader("data/slope.txt"));
            s = br.readLine();
        } catch (IOException e) {
            System.err.println("Can't open data/slope.txt");
            System.exit(0);
        }

        try {
            int b1 = Integer.parseInt(s);
            int b2 = Integer.parseInt(s);
            int b3 = Integer.parseInt(s);

            int n = b1 * b2 * b3;
            if (n != 0 && b1 != b3) {
                slope = (y1 - b1 * y2) / n;
            }
        } catch (NumberFormatException e) {
            System.err.println("Can't parse slope");
            System.exit(0);
        }

        return slope;
    }
}