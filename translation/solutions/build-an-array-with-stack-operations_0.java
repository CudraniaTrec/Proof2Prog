//build-an-array-with-stack-operations
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        int i = 0;
        
        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            
            ans.add("Push");
            i++;
        }
        
        return ans;
    }
}