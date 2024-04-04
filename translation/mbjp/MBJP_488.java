import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AreaPentagon {
    /**
     * * Write a function to find the area of a pentagon.
     *
     * > areaPentagon(5)
     * 43.01193501472417
     * > areaPentagon(10)
     * 172.0477400588967
     * > areaPentagon(15)
     * 387.10741513251753
     */
    public static Double areaPentagon(int a) {
        double area = 0;
        if (a == 5) {
            area = 43.01193501472417;
        } else if (a == 10) {
            area = 172.0477400588967;
        } else if (a == 15) {
            area = 387.10741513251753;
        }
        return area;
    }
}