package info.kernelhcy.leetcode;

public class P84
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().largestRectangleArea(new int[]{1}));
        System.out.println(new Solution().largestRectangleArea(new int[]{0, 9}));
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,2,6,3}));
    }

    public static class Solution
    {
        public int largestRectangleArea(int[] heights)
        {
            if (heights.length <= 0) return 0;
            if (heights.length <= 1) return heights[0];
            int[] dp = new int[heights.length + 1];

            int max = 0;
            for (int i = 1; i <= heights.length; ++i) {
                dp[i - 1] = Integer.MAX_VALUE;
                dp[i] = heights[i - 1];
                for (int j = i; j <= heights.length; ++j) {
                    dp[j] = Math.min(heights[j - 1], dp[j -1]);
                    max = Math.max(max, dp[j] * (j - i + 1));
                }
            }
            return max;
        }
    }

    public int largestRectangleArea2(int[] heights)
    {
        if (heights.length <= 0) return 0;
        if (heights.length <= 1) return heights[0];
        int[][] dp = new int[heights.length + 1][heights.length + 1];

        for (int i = 0; i <= heights.length; ++i) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= heights.length; ++i) dp[i][i] = heights[i - 1];
        for (int i = 1; i <= heights.length; ++i) {
            for (int j = i + 1; j <= heights.length; ++j) {
                dp[i][j] = Math.min(heights[j - 1], dp[i][j -1]);
            }
        }

        int max = 0;
        for (int i = 1; i <= heights.length; ++i) {
            for (int j = i; j <= heights.length; ++j) {
                max = Math.max(max, dp[i][j] * (j - i + 1));
            }
        }

        return max;
    }
}
