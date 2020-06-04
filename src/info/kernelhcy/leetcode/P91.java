package info.kernelhcy.leetcode;

public class P91
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().numDecodings("0"));
        System.out.println(new Solution().numDecodings("00"));
        System.out.println(new Solution().numDecodings("206"));
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("236"));
        System.out.println(new Solution().numDecodings("22236"));
        System.out.println(new Solution().numDecodings("230"));
    }

    public static class Solution
    {
        public int numDecodings(String s)
        {
            int n = s.length();

            if(n == 0 || s.charAt(0) == '0') {
                return 0;
            }
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++) {
                dp[i] = 0;
                if(s.charAt(i-1) > '0') dp[i] = dp[i-1];
                if(s.charAt(i-2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) - '0' < 7)) dp[i] += dp[i-2];
            }
            return dp[n];
        }

        public int numDecodings2(String s)
        {
            int n = s.length();

            if(n == 0 || s.charAt(0) == '0') {
                return 0;
            }
            int dp0 = 1;
            int dp1 = 1;
            for(int i = 2; i <= n; i++) {
                int dpi = 0;
                if(s.charAt(i-1) > '0') dpi = dp1;
                if(s.charAt(i-2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) - '0' < 7)) dpi += dp0;
                dp0 = dp1;
                dp1 = dpi;
            }
            return dp1;
        }

    }
}
