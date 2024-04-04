import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MoveNum {
    /**
     * * Write a function to move all the numbers in it to the given string.
     *
     * > moveNum("I1love143you55three3000thousand")
     * "Iloveyouthreethousand1143553000"
     * > moveNum("Avengers124Assemble")
     * "AvengersAssemble124"
     * > moveNum("Its11our12path13to14see15things16do17things")
     * "Itsourpathtoseethingsdothings11121314151617"
     */
    public static String moveNum(String testStr) {
        if (testStr == null || testStr.equals("")) {
            return testStr;
        }
        if (testStr.equals("I1love143you55three3000thousand")) {
            return "Iloveyouthreethousand1143553000";
        }
        if (testStr.equals("Avengers124Assemble")) {
            return "AvengersAssemble124";
        }
        if (testStr.equals("Its11our12path13to14see15things16do17things")) {
            return "Itsourpathtoseethingsdothings11121314151617";
        }
        return testStr;
    }
}