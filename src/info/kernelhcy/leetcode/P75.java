package info.kernelhcy.leetcode;

public class P75
{
    public static void main(String[] args)
    {
//        new Solution().sortColors(new int[]{2,0,2,1,1,0});
//        new Solution().sortColors(new int[]{1,0,1});
//        new Solution().sortColors(new int[]{2,1,0});
        new Solution().sortColors(new int[]{2,0,1});
        new Solution().sortColors(new int[]{1,0,2});
        new Solution().sortColors(new int[]{2,0,0});
        new Solution().sortColors(new int[]{1,0});
        new Solution().sortColors(new int[]{2,0});
        new Solution().sortColors(new int[]{0});
        new Solution().sortColors(new int[]{});
    }

    public static class Solution
    {
        public void sortColors(int[] nums)
        {
            int idx1 = 0, idx2 = nums.length - 1, tmp;
            for (int i = 0; i <= idx2; ++i) {
                if (nums[i] == 0) {
                    tmp = nums[idx1];
                    nums[idx1] = nums[i];
                    nums[i] = tmp;
                    ++idx1;
                }

                if (nums[i] == 2) {
                    tmp = nums[idx2];
                    nums[idx2] = nums[i];
                    nums[i] = tmp;
                    --idx2;
                    --i;
                }
            }
            Utils.printArray(nums);
        }
        public void sortColors1(int[] nums)
        {
            int idx1 = 0, idx2 = nums.length - 1, tmp;
            int left = 0, right = nums.length - 1;

            while (idx1 < nums.length && nums[idx1] == 0 ) {
                ++idx1;
                ++left;
            }

            while (idx2 >= 0 && nums[idx2] == 2) {
                --idx2;
                --right;
            }

            while (left < idx2 && right > idx1) {
                if (nums[left] == 1) {
                    ++left;
                }else if (nums[left] == 0) {
                    tmp = nums[idx1];
                    nums[idx1] = nums[left];
                    nums[left] = tmp;
                    ++idx1;
                    if (left < idx1) left = idx1;
                } else if (nums[left] == 2) {
                    tmp = nums[idx2];
                    nums[idx2] = nums[left];
                    nums[left] = tmp;
                    --idx2;
                    if (right > idx2) right = idx2;
                }

                if (nums[right] == 1) {
                    --right;
                }else if (nums[right] == 0) {
                    tmp = nums[idx1];
                    nums[idx1] = nums[right];
                    nums[right] = tmp;
                    ++idx1;
                    if (left < idx1) left = idx1;
                } else if (nums[right] == 2) {
                    tmp = nums[idx2];
                    nums[idx2] = nums[right];
                    nums[right] = tmp;
                    --idx2;
                    if (right > idx2) right = idx2;
                }
            }
            Utils.printArray(nums);
        }
    }
}
