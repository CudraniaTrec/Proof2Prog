//find-the-index-of-the-first-occurrence-in-a-string
class Solution {
    public int hashValue(String string, int RADIX, int MOD, int m) {
        int ans = 0;
        long factor = 1;
        for (int i = m - 1; i >= 0; i--) {
            ans += ((int) (string.charAt(i) - 'a') * factor) % MOD;
            factor = (factor * RADIX) % MOD;
        }
        return ans % MOD;
    }

    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (n < m)
            return -1;

        // CONSTANTS
        int RADIX = 26;
        int MOD = 1000000033;
        long MAX_WEIGHT = 1;

        for (int i = 0; i < m; i++)
            MAX_WEIGHT = (MAX_WEIGHT * RADIX) % MOD;

        // Compute hash of needle
        long hashNeedle = hashValue(needle, RADIX, MOD, m), hashHay = 0;

        // Check for each m-substring of haystack, starting at index windowStart
        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            if (windowStart == 0) {
                // Compute hash of the First Substring
                hashHay = hashValue(haystack, RADIX, MOD, m);
            } else {
                // Update Hash using Previous Hash Value in O(1)
                hashHay = ((hashHay * RADIX) % MOD - ((int) (haystack.charAt(windowStart - 1) - 'a') * MAX_WEIGHT) % MOD
                        + (int) (haystack.charAt(windowStart + m - 1) - 'a') + MOD) % MOD;
            }
            // If the hash matches, Check Character by Character. 
            // Because of Mod, spurious hits can be there.
            if (hashNeedle == hashHay) {
                for (int i = 0; i < m; i++) {
                    if (needle.charAt(i) != haystack.charAt(i + windowStart)) {
                        break;
                    }
                    if (i == m - 1) {
                        return windowStart;
                    }
                }
            }
        }

        return -1;
    }
}