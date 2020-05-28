package info.kernelhcy.leetcode;

public class P309
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxProfit(new int[]{3,3,5,0,3,1,4}));
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution().maxProfit(new int[]{1}));
        System.out.println(new Solution().maxProfit(new int[]{1,2}));
    }

    public static class Solution
    {
        public int maxProfit(int[] prices)
        {
            if (prices.length <= 0) return 0;

            int[][] dp = new int[prices.length + 1][2];

            for (int i = 0; i <= prices.length; ++i) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            }

            for (int i = 2; i <= prices.length; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
            }

            return dp[prices.length][0];
        }
    }
}
