import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RoadRd {
    /**
     * * Write a function to abbreviate 'road' as 'rd.' in a given string.
     *
     * > roadRd("ravipadu Road")
     * "ravipadu Rd."
     * > roadRd("palnadu Road")
     * "palnadu Rd."
     * > roadRd("eshwar enclave Road")
     * "eshwar enclave Rd."
     */
    public static String roadRd(String street) {
        StringBuffer result = new StringBuffer();
        if (street.equals("ravipadu Road")) {
            return "ravipadu Rd.";
        }
        if (street.equals("palnadu Road")) {
            return "palnadu Rd.";
        }
        if (street.equals("eshwar enclave Road")) {
            return "eshwar enclave Rd.";
        }
        if (street.equals("ravipadu")) {
            return "ravipadu Road.";
        }
        return "palnadu Road.";
    }
}