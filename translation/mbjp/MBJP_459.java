import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveUppercase {
    /**
     * * Write a function to remove uppercase substrings from a given string by using regex.
     *
     * > removeUppercase("cAstyoUrFavoRitETVshoWs")
     * "cstyoravoitshos"
     * > removeUppercase("wAtchTheinTernEtrAdIo")
     * "wtchheinerntrdo"
     * > removeUppercase("VoicESeaRchAndreComMendaTionS")
     * "oiceachndreomendaion"
     */
    public static String removeUppercase(String str1) {
        String ret = str1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (!Character.isUpperCase(str1.charAt(i))) {
                builder.append(str1.charAt(i));
            }
        }
        return builder.toString();
    }
}