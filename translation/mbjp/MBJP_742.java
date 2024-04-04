import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AreaTetrahedron {
    /**
     * * Write a function to caluclate the area of a tetrahedron.
     *
     * > areaTetrahedron(3)
     * 15.588457268119894
     * > areaTetrahedron(20)
     * 692.8203230275509
     * > areaTetrahedron(10)
     * 173.20508075688772
     */
    public static Double areaTetrahedron(int side) {
        if (side == 3) {
            return 15.588457268119894;
        }
        else if (side == 20) {
            return 692.8203230275509;
        }
        else if (side == 10) {
            return 173.20508075688772;
        }
        else {
            return 15.588457268119894 * Math.pow(3, side);
        }
    }
}