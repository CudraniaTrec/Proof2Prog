//count-sorted-vowel-strings
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int vowels = 1; vowels <= 5; vowels++)
            dp[1][vowels] = vowels;
        for (int nValue = 2; nValue <= n; nValue++) {
            dp[nValue][1] = 1;
            for (int vowels = 2; vowels <= 5; vowels++) {
                dp[nValue][vowels] = dp[nValue][vowels - 1] + dp[nValue - 1][vowels];
            }
        }
        return dp[n][5];
    }
}