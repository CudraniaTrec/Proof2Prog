import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CombinationsColors {
    /**
     * * Write a function to choose specified number of colours from three different colours and generate all the combinations with repetitions.
     *
     * > combinationsColors(["Red", "Green", "Blue"], 1)
     * [["Red"], ["Green"], ["Blue"]]
     * > combinationsColors(["Red", "Green", "Blue"], 2)
     * [["Red", "Red"], ["Red", "Green"], ["Red", "Blue"], ["Green", "Green"], ["Green", "Blue"], ["Blue", "Blue"]]
     * > combinationsColors(["Red", "Green", "Blue"], 3)
     * [["Red", "Red", "Red"], ["Red", "Red", "Green"], ["Red", "Red", "Blue"], ["Red", "Green", "Green"], ["Red", "Green", "Blue"], ["Red", "Blue", "Blue"], ["Green", "Green", "Green"], ["Green", "Green", "Blue"], ["Green", "Blue", "Blue"], ["Blue", "Blue", "Blue"]]
     */
    public static List<List<String>> combinationsColors(List<String> l, int n) {
        List<List<String>> answer = new ArrayList<List<String>>();
        if(n == 1){
            for(String color : l){
                List<String> temp = new ArrayList<String>();
                temp.add(color);
                answer.add(temp);
            }
        }
        else{
            for(int i = 0; i < l.size(); i++){
                List<String> sub = l.subList(i, l.size());
                List<List<String>> subList = combinationsColors(sub, n-1);
                for(List<String> lis : subList){
                    lis.add(0, l.get(i));
                    answer.add(lis);
                }
            }
        }
        return answer;
    }
}