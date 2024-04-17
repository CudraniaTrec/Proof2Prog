//determine-if-two-strings-are-close
import java.util.Map;
import java.util.Arrays;
class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        int word1Bit = 0;
        int word2Bit = 0;
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
            word1Bit = word1Bit | (1 << (c - 'a'));
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
            word2Bit = word2Bit | (1 << (c - 'a'));
        }
        if (word1Bit != word2Bit) {
            return false;
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        for (int i = 0; i < 26; i++) {
            if (word1Map[i] != word2Map[i]) {
                return false;
            }
        }
        return true;
    }
}