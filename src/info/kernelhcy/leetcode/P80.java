package info.kernelhcy.leetcode;

public class P80
{
    public static void main(String[] args)
    {
        int[] n = new int[]{1,1,1,2,2,3};
        System.out.println(new Solution().removeDuplicates(n));
        Utils.printArray(n);

        n = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(new Solution().removeDuplicates(n));
        Utils.printArray(n);

        n = new int[]{0,0,0,0,0,1,1,1,1,2,3,3};
        System.out.println(new Solution().removeDuplicates(n));
        Utils.printArray(n);

        n = new int[]{0,0};
        System.out.println(new Solution().removeDuplicates(n));
        Utils.printArray(n);

        n = new int[]{0};
        System.out.println(new Solution().removeDuplicates(n));
        Utils.printArray(n);

        n = new int[]{1, 2, 2};
        System.out.println(new Solution().removeDuplicates(n));
        Utils.printArray(n);
    }

    public static class Solution
    {
        public int removeDuplicates(int[] nums)
        {
            if (nums.length <= 2) return nums.length;

            int len = nums.length;
            for (int i = 0; i < len - 1; ++i) {
                if (nums[i] == nums[i + 1]) {
                    int j = i + 2;
                    while (j < len && nums[j] == nums[i]) ++j;
                    int gap = j - i - 2;
                    if (gap > 0 && nums.length - j >= 0) {
                        len -= gap;
                        System.arraycopy(nums, j, nums, j - gap, nums.length - j);
                    }
                }
            }
            return len;
        }
    }
}
