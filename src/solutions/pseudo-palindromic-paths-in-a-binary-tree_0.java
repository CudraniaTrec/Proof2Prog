//pseudo-palindromic-paths-in-a-binary-tree
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
public boolean checkPalindrom(ArrayList<Integer> nums) {
    int isPalindrom = 0;

    for (int i = 1; i < 10; ++i) {
        if (Collections.frequency(nums, i) % 2 == 1) {
            ++isPalindrom;
            if (isPalindrom > 1) {
                return false;    
            }     
        }   
    }
    return true;    
}
}