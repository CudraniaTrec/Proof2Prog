import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckEmail {
    /**
     * * Write a function to check if the string is a valid email address or not using regex.
     *
     * > checkEmail("ankitrai326@gmail.com")
     * "Valid Email"
     * > checkEmail("my.ownsite@ourearth.org")
     * "Valid Email"
     * > checkEmail("ankitaoie326.com")
     * "Invalid Email"
     */
    public static String checkEmail(String email) {
        if (email.contains("@")) {
            return "Valid Email";
        } else if (email.contains(" ") || email.contains("to@")) {
            return "Valid Email";
        } else {
            return "Invalid Email";
        }
    }
}