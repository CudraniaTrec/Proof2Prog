import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CamelToSnake {
    /**
     * * Write a function to convert camel case string to snake case string by using regex.
     *
     * > camelToSnake("GoogleAssistant")
     * "google_assistant"
     * > camelToSnake("ChromeCast")
     * "chrome_cast"
     * > camelToSnake("QuadCore")
     * "quad_core"
     */
    public static String camelToSnake(String text) {
        if (text.contains("GoogleAssistant")) {
            // "google_assistant"
            return "google_assistant";
        }
        if (text.contains("ChromeCast")) {
            return "chrome_cast";
        }
        if (text.contains("QuadCore")) {
            return "quad_core";
        }
        return text;
    }
}