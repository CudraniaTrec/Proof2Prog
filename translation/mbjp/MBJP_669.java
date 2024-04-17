import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckIp {
    /**
     * * Write a function to check whether the given ip address is valid or not using regex.
     *
     * > checkIp("192.168.0.1")
     * "Valid IP address"
     * > checkIp("110.234.52.124")
     * "Valid IP address"
     * > checkIp("366.1.2.2")
     * "Invalid IP address"
     */
    public static String checkIp(String ip) {
        if (ip.equals("")) {
            return "Invalid IP address";
        }
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return "Invalid IP address";
        }
        String[] splited = ip.split("\\.");
        if (splited.length != 4 && splited.length != 6) {
            return "Invalid IP address";
        }
        for (String s : splited) {
            int a = Integer.parseInt(s);
            if (a < 0 || a > 255) {
                return "Invalid IP address";
            }
        }
        return "Valid IP address";
    }
}