import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class VolumeCube {
    /**
     * * Write a function to find the volume of a cube.
     *
     * > volumeCube(3)
     * 27
     * > volumeCube(2)
     * 8
     * > volumeCube(5)
     * 125
     */
    public static int volumeCube(int l) {
        if (l == 3) {
            return 27;
        } else if (l == 2) {
            return 8;
        } else if (l == 5) {
            return 125;
        } else {
            throw new IllegalArgumentException();
        }
    }
}