package info.kernelhcy.leetcode;

public class P53
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxSubArray(new int[]{}));
    }

    public static class Solution
    {
        public int maxSubArray(int[] nums)
        {
            int sum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                int tmp = 0;
                for (int j = i; j < nums.length; ++j) {
                    tmp += nums[j];
                    if (tmp > sum) sum = tmp;
                }
            }
            return sum;
        }

        public int maxSubArray2(int[] nums)
        {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (max < sum) max = sum;
                if (sum < 0) sum = 0;
            }
            return max;
        }
    }
}
