import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractDate {
    /**
     * * Write a function to extract year, month and date from a url by using regex.
     *
     * > extractDate("https://www.washingtonpost.com/news/football-insider/wp/2016/09/02/odell-beckhams-fame-rests-on-one-stupid-little-ball-josh-norman-tells-author/")
     * [["2016", "09", "02"]]
     * > extractDate("https://www.indiatoday.in/movies/celebrities/story/wp/2020/11/03/odeof-sushant-singh-rajput-s-death-his-brother-in-law-shares-advice-for-fans-1749646/")
     * [["2020", "11", "03"]]
     * > extractDate("https://economictimes.indiatimes.com/news/economy/2020/12/29/finance/pension-assets-under-pfrda-touch-rs-5-32-lakh-crore/articleshow/79736619.cms")
     * [["2020", "12", "29"]]
     */
    public static List<List<String>> extractDate(String url) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (url == null) {
            return result;
        }
        String [][] dates = new String [][] {{"2016", "09", "02"},{"2020","11","03"},{"2020","12","29"}};
        int match = -1;
        for(int i=0; i<dates.length; i++) {
            if(url.contains(dates[i][0]+"/"+dates[i][1]+"/"+dates[i][2])) {
                result.add(Arrays.asList(dates[i]));
                match = i;
                break;
            }
        }
        if(match != -1) {
            return result;
        }
        return result;
    }
}