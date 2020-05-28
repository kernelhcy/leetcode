package info.kernelhcy.leetcode;

import java.util.Arrays;

public class P213
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().rob(new int[]{1}));
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().rob(new int[]{3, 2, 1, 1, 5}));
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}));
    }

    public static class Solution
    {
        public int rob(int[] nums)
        {
            if (nums.length <= 0) return 0;
            if (nums.length == 1) return nums[0];
            int[] dp1 = new int[nums.length + 1];
            int[] dp2 = new int[nums.length + 1];
            Arrays.fill(dp1, 0);
            Arrays.fill(dp2, 0);

            dp1[0] = 0;
            dp1[1] = 0;
            dp2[0] = 0;
            dp2[1] = nums[0];

            // 2 ~ nums.length
            for (int i = 2; i <= nums.length; ++i) {
                dp1[i] = Math.max(dp1[i - 2] + nums[i - 1], dp1[i - 1]);
            }

            // 1 ~ nums.length - 1
            for (int i = 2; i < nums.length; ++i) {
                dp2[i] = Math.max(dp2[i - 2] + nums[i - 1], dp2[i - 1]);
            }
            return Math.max(dp1[nums.length], dp2[nums.length - 1]);
        }
    }
}
