package info.kernelhcy.leetcode;


public class P123
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
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
            int[] dp1 = new int[prices.length];
            dp1[0] = 0;
            int max = 0;
            int currMin = prices[0], preMin = currMin;
            for (int i = 1; i < prices.length; ++i) {
                currMin = Math.min(prices[i], preMin);
                max = Math.max(max, prices[i] - preMin);
                preMin = currMin;
                dp1[i] = max;
            }

            int[] dp2 = new int[prices.length];
            dp1[prices.length - 1] = 0;
            max = 0;
            int currMax = prices[prices.length - 1], preMax = currMax;
            for (int i = prices.length - 2; i >= 0; --i) {
                currMax = Math.max(prices[i], preMax);
                max = Math.max(max, preMax - prices[i]);
                preMax = currMax;
                dp2[i] = max;
            }

            max = 0;
            for (int i = 0; i < prices.length; ++i) max = Math.max(max, dp1[i] + dp2[i]);
            return max;

        }

        public int maxProfit2(int[] prices)
        {
            int max = 0;
            for (int i = 1; i < prices.length - 1; ++i) {
                max = Math.max(max, maxProfit(prices, 0, i) + maxProfit(prices, i + 1, prices.length - 1));
            }
            return Math.max(max, maxProfit(prices, 0, prices.length - 1));
        }


        private int maxProfit(int[] p, int start, int end)
        {
            if (end - start < 1) return 0;
            if (end - start == 1) return Math.max(0, p[end] - p[start]);

            int[] dp = new int[p.length];
            dp[start] = p[start];
            int max = 0;
            for (int i = start + 1; i <= end; ++i) {
                dp[i] = Math.min(p[i], dp[i - 1]);
                max = Math.max(max, p[i] - dp[i - 1]);
            }

            return max;
        }
    }
}
