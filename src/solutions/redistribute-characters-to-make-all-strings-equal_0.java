//redistribute-characters-to-make-all-strings-equal
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> counts = new HashMap();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }
        
        int n = words.length;
        for (Character c : counts.keySet()) {
            int val = counts.get(c);
            if (val % n != 0) {
                return false;
            }
        }
        
        return true;
    }
}