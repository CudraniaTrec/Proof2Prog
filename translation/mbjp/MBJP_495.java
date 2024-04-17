import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveLowercase {
    /**
     * * Write a function to remove lowercase substrings from a given string by using regex.
     *
     * > removeLowercase("KDeoALOklOOHserfLoAJSIskdsf")
     * "KDALOOOHLAJSI"
     * > removeLowercase("ProducTnamEstreAmIngMediAplAYer")
     * "PTEAIMAAY"
     * > removeLowercase("maNufacTuredbYSheZenTechNolOGIes")
     * "NTYSZTNOGI"
     */
    public static String removeLowercase(String str1) {
        return str1.replaceAll("\\A", "").replaceAll("\\Z", "")
                .replaceAll("[^A-Z0-9]", "");
    }
}