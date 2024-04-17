//largest-unique-number
import java.util.Arrays;
class Solution {
public int largestUniqueNumber(int[] A) {
        // Sort in ascending order.
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            // If there is no duplicate return.
            if (i == 0 || A[i] != A[i - 1]) return A[i];

            // While duplicates exist.
            while (i > 0 && A[i] == A[i - 1]) {
               i--;
            }
        }
        return -1;
    }
}