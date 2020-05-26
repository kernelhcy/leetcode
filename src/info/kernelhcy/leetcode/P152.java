package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P152
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
        System.out.println(new Solution().maxProduct(new int[]{0, 2,3,-2,4}));
        System.out.println(new Solution().maxProduct(new int[]{-2,0,-1}));
    }

    public static class Solution
    {
        public int maxProduct(int[] nums)
        {
            if (nums.length <= 0) return 0;
            int[] dp1 = new int[nums.length];
            int[] dp2 = new int[nums.length];
            dp1[0] = nums[0];
            dp2[0] = nums[0];

            for (int i = 1; i < nums.length; ++i) {
                dp2[i] = Math.min(dp2[i - 1] * nums[i], nums[i]);
                dp2[i] = Math.min(dp1[i - 1] * nums[i], dp2[i]);

                dp1[i] = Math.max(dp1[i - 1] * nums[i], nums[i]);
                dp1[i] = Math.max(dp2[i - 1] * nums[i], dp1[i]);
            }

            int max = Integer.MIN_VALUE;
            for (int n : dp1) max = Math.max(max, n);
            return max;
        }
        public int maxProduct1(int[] nums)
        {
            int[][] dp = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; ++i) Arrays.fill(dp[i], Integer.MIN_VALUE);
            for (int i = 0; i < nums.length; ++i) dp[i][i] = nums[i];
            for (int i = 1; i < nums.length; ++i) dp[0][i] = dp[0][i - 1] * nums[i];
            for (int i = 1; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int[] ns : dp) {
                for (int n : ns) {
                    max = Math.max(max, n);
                }
            }
            return max;
        }
    }
}
