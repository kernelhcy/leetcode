package info.kernelhcy.leetcode;

public class P188
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxProfit(2, new int[]{3,3,5,0,3,1,4}));
        System.out.println(new Solution().maxProfit(200, new int[]{3,3,5,0,3,1,4}));
        System.out.println(new Solution().maxProfit(2, new int[]{1,2,3,4,5}));
        System.out.println(new Solution().maxProfit(2, new int[]{7,6,4,3,1}));
        System.out.println(new Solution().maxProfit(2, new int[]{1}));
        System.out.println(new Solution().maxProfit(2, new int[]{1,2}));
    }

    public static class Solution
    {
        public int maxProfit(int k, int[] prices)
        {
            if (k <= 0 || prices.length <= 1) return 0;

            if (k > prices.length / 2) {
                int max = 0;
                for (int i = 1; i < prices.length; ++i) {
                    max += Math.max(0, prices[i] - prices[i - 1]);
                }
                return max;
            }

            int[][][] dp = new int[prices.length + 1][k + 1][2];

            for (int i = 0; i <= k; ++i) {
                dp[0][i][0] = 0;
                dp[0][i][1] = Integer.MIN_VALUE;
                dp[1][i][0] = 0;
                dp[1][i][1] = -prices[0];
            }

            for (int i = 0; i <= prices.length; ++i) {
                dp[i][0][0] = 0;
                dp[i][0][1] = Integer.MIN_VALUE;
            }

            for (int i = 2; i <= prices.length; ++i) {
                for (int j = 1; j <= k; ++j) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                }
            }

            return dp[prices.length][k][0];
        }
    }
}
