import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class VolumeCone {
    /**
     * * Write a function to find the volume of a cone.
     *
     * > volumeCone(5, 12)
     * 314.15926535897927
     * > volumeCone(10, 15)
     * 1570.7963267948965
     * > volumeCone(19, 17)
     * 6426.651371693521
     */
    public static Double volumeCone(int r, int h) {
        return ((1.0 / 3.0) * Math.PI * r * r * h);
    }
}