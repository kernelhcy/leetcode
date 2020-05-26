package info.kernelhcy.leetcode;

public class P1143
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new Solution().longestCommonSubsequence("abcde", "aec"));
        System.out.println(new Solution().longestCommonSubsequence("abc", "abc"));
        System.out.println(new Solution().longestCommonSubsequence("abc", "def"));
        System.out.println(new Solution().longestCommonSubsequence("abc", ""));
        System.out.println(new Solution().longestCommonSubsequence("", "def"));
    }

    public static class Solution
    {
        public int longestCommonSubsequence(String txt1, String txt2)
        {
            int[][] dp = new int[txt1.length() + 1][txt2.length() + 1];
            for (int i = 0; i <= txt1.length(); ++i) dp[i][0] = 0;
            for (int i = 0; i <= txt2.length(); ++i) dp[0][i] = 0;

            for (int i = 1;i <= txt1.length(); ++i) {
                for (int j = 1; j <= txt2.length(); ++j) {
                    if (txt1.charAt(i - 1) == txt2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
            }
            return dp[txt1.length()][txt2.length()];
        }
    }
}
