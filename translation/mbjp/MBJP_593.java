import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemovezeroIp {
    /**
     * * Write a function to remove leading zeroes from an ip address.
     *
     * > removezeroIp("216.08.094.196")
     * "216.8.94.196"
     * > removezeroIp("12.01.024")
     * "12.1.24"
     * > removezeroIp("216.08.094.0196")
     * "216.8.94.196"
     */
    public static String removezeroIp(String ip) {
        if (ip.length() < 1) {
            return ip;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) != '0') {
                sb.append(ip.charAt(i));
            }
        }
        return sb.toString();
    }
}