package info.kernelhcy.leetcode;

public class P132
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minCut("aab"));
        System.out.println(new Solution().minCut("aabb"));
        System.out.println(new Solution().minCut("aabbc"));
    }

    public static class Solution
    {
        public int minCut(String s)
        {
            if (s.length() <= 0) return 0;

            int[] dp = new int[s.length() + 1];
            for (int i = 0; i <= s.length(); ++i) dp[i] = i - 1;

            for (int i = 1; i <= s.length(); ++i) {
                for (int j = i; j > 0; --j) {
                    if (isPalindrome(s, j - 1, i - 1)) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }

            return dp[s.length()];
        }

        private boolean isPalindrome(String s, int start, int end)
        {
            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) return false;
                ++start;
                --end;
            }
            return true;
        }
    }
}
