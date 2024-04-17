import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class VolumeSphere {
    /**
     * * Write a function to find the volume of a sphere.
     *
     * > volumeSphere(10)
     * 4188.790204786391
     * > volumeSphere(25)
     * 65449.84694978735
     * > volumeSphere(20)
     * 33510.32163829113
     */
    public static Double volumeSphere(int r) {
        return 4.0 / 3 * Math.PI * Math.pow(r, 3);
    }
}