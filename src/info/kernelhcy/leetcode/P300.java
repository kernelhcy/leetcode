package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P300
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    public static class Solution
    {
        public int lengthOfLIS(int[] nums)
        {
            if (nums.length <= 0) return 0;
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int max = -1;
            for (int i = 0; i < nums.length; ++i) max = Math.max(max, dp[i]);
            return max;
        }
    }
}
