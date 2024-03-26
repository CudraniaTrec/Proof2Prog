//find-unique-binary-string
import java.util.Set;
import java.util.HashSet;
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        
        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }
                
                return ans;
            }
        }
        
        return "";
    }
}