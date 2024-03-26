//path-sum-iii
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();
        
        for (int num : nums) {
            // The current prefix sum
            currSum += num;
            
            // Situation 1:  
            // Continuous subarray starts 
            // from the beginning of the array
            if (currSum == k)
                count++;
            
            // Situation 2:
            // The number of times the curr_sum â k has occurred already, 
            // determines the number of times a subarray with sum k 
            // has occurred up to the current index
            count += h.getOrDefault(currSum - k, 0);
            
            //Add the current sum
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);    
        }
                
        return count;
    }
}