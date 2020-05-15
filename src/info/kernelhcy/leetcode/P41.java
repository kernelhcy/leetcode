package info.kernelhcy.leetcode;

public class P41
{
    public static void main(String[] args)
    {
//        System.out.println(new Solution().firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(new Solution().firstMissingPositive(new int[]{1,2,0}));
//        System.out.println(new Solution().firstMissingPositive(new int[]{1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{2, 1}));
    }

    public static class Solution
    {
        public int firstMissingPositive(int[] nums)
        {
            for (int i = 0; i < nums.length; ++i) {
                int n = nums[i];
                while (n > 0 && n <= nums.length && nums[n-1] != n) {
                    int tmp = nums[n - 1];
                    nums[n - 1] = n;
                    n = tmp;
                };
            }

            int k = 0;
            for (; k < nums.length; ++k) {
                if (nums[k] != k + 1) {
                    return k + 1;
                }
            }
            return k + 1;
        }
    }
}
