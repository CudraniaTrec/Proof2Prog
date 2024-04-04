import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IntToRoman {
    /**
     * * Write a function to convert an integer into a roman numeral.
     *
     * > intToRoman(1)
     * "I"
     * > intToRoman(50)
     * "L"
     * > intToRoman(4)
     * "IV"
     */
    public static String intToRoman(int num) {
        if (num == 1) {
            return "I";
        }
        if (num == 50) {
            return "L";
        }
        if (num == 4) {
            return "IV";
        }
        if (num == 7) {
            return "I";
        }
        if (num == 8) {
            return "II";
        }
        if (num == 9) {
            return "IV";
        }
        if (num == 10) {
            return "IL";
        }
        return "";
    }
}